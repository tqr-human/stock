package cn.stock.controller;

import cn.stock.bean.*;
import cn.stock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/wv")
public class WVController {
    @Autowired
    WVService wvService;
    @Autowired
    StockService stockService;
    @Autowired
    Stock_LogService stockLogService;
    @Autowired
    UnitService unitService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    HttpServletRequest request;


    @PostMapping("/select")
    public String selectView(Model model, WV wv) {
        Unit unit = unitService.findById(wv.getUnitId());
        model.addAttribute("realunit", unit);
        try {
            model.addAttribute("unit", unitService.findAll());
            List<Goods> goods = goodsService.findByHql("from Goods where unitId=?", wv.getUnitId());
            if (goods.size() == 0) {
                model.addAttribute("msg", "该单位没有对应物料");
            }
            model.addAttribute("goods", goods);
        } catch (Exception e) {
            model.addAttribute("msg", "出错了：)");
            model.addAttribute("unit", unitService.findAll());
            return "wvaddplus";
        }
        return "wvaddplus";
    }

    @GetMapping("/")
    public String indexView(
            Model model){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("wv",wvService.findAll());
        return "wv";
    }

    @GetMapping("/add")
    public String addView(Model model) {
        model.addAttribute("unit", unitService.findAll());
        model.addAttribute("goods", goodsService.findAll());
        return "wvadd";
    }

    @GetMapping("/delete/{id}")
    public String deleteView(Model model, @PathVariable int id) {
        WV wv = (WV) request.getSession().getAttribute("wv");
//        Stock stock = stockService.findStockByName(new Stock(wv.getProduct_name()));
//        int inventory_id = stock.getId();
//        /**
//         * 删除入库单，同时删除库存，增加库存删除记录
//         */
//        else{
//            stock = stockService.findByStockId(inventory_id);
//            stock.setInventory(stock.getInventory()-wv.getAmount());
//            stockService.updateStock(stock);
//            Stock_Log stockLog = new Stock_Log();
//            stockLog.setAmount(wv.getAmount());
//            stockLog.setCreated(new Date());
//            stockLog.setAction(2);
//            stockLog.setInventory_id(inventory_id);
//            stockLogService.createStockLog(stockLog);
        try {
            wvService.deleteWV(id);
            model.addAttribute("msg", "删除成功");
            model.addAttribute("wv", wvService.findAll());
        } catch (Exception e) {
            model.addAttribute("msg", "删除失败");
            model.addAttribute("wv", wvService.findAll());
        }
//        }
        return "wv";
    }
    @PostMapping("/save")
    public String updateView(
            Model model, WV wv) {
        try {
            if (wv.getAmount().equals("")||wv.getAmount()==null) {
                model.addAttribute("msg", "数量不能为空");
                model.addAttribute("wv", wvService.findAll());
                return "wv";
            }
            Unit unit = unitService.findById(wv.getUnitId());
            wv.setUnit(unit);
            Goods goods = goodsService.findById(wv.getGoodsId());
            wv.setGoods(goods);
            wv.setProduct_name(goods.getName());
            if (wv.getAmount() > goods.getMaxInventory()) {
                model.addAttribute("msg", goods.getName()+"数量不能超过最大库存数"+goods.getMaxInventory()+"，新增失败");
                model.addAttribute("wv", wvService.findAll());
            }else {
                Date date = new Date();
                wv.setCreated(date);
                wv.setStatus(1);
                wv.setCreater((User) request.getSession().getAttribute("user"));
                wvService.createWV(wv);
                model.addAttribute("msg", "新增成功");
                model.addAttribute("wv", wvService.findAll());
            }
        } catch (Exception e) {
            model.addAttribute("msg", "新增失败");
            model.addAttribute("wv", wvService.findAll());
        }
        return "wv";
    }

    @GetMapping("/verify/{id}")
    public String verifyView(Model model, @PathVariable int id) {
        WV wv = wvService.findByWVId(id);
        Stock stock;
        Goods goods = goodsService.findById(wv.getGoodsId());
        try{
            stock = stockService.findStockByName(new Stock(wv.getProduct_name()));
            if ((stock.getMax_inventory() - stock.getInventory()) < wv.getAmount()) {
                model.addAttribute("msg", "超过最大库存，不能审核该入库单");
                model.addAttribute("wv", wvService.findAll());
            }else {
                stock = stockService.addByWV(wv);
                wv.setStock(stock);
                wv.setVerifier((User) request.getSession().getAttribute("user"));
                wvService.updateWV(wv);
                stockLogService.addByWV(wv,stock);
                wv.setStatus(2);
                wvService.updateWV(wv);
                goods.setStock(stock);
                goodsService.updateGoods(goods);
                model.addAttribute("msg", "审核成功");
                model.addAttribute("wv", wvService.findAll());
            }
        }catch (Exception e) {
            stock = stockService.addByWV(wv);
            wv.setStock(stock);
            wv.setVerifier((User) request.getSession().getAttribute("user"));
            wvService.updateWV(wv);
            stockLogService.addByWV(wv,stock);
            wv.setStatus(2);
            wvService.updateWV(wv);
            goods.setStock(stock);
            goodsService.updateGoods(goods);
            model.addAttribute("msg", "审核成功");
            model.addAttribute("wv", wvService.findAll());
            return "wv";
        }
        return "wv";
    }

    @GetMapping("/verifydeny/{id}")
    public String verifyDenyView(Model model, @PathVariable int id) {
        try {
            WV wv = wvService.findByWVId(id);
            Stock stock = stockService.findStockByName(new Stock(wv.getProduct_name()));
            int temp = stock.getInventory() - wv.getAmount();
            if (temp >= 0) {
                stock.setInventory(temp);
                stockService.updateStock(stock);
                stockLogService.denyByWV(wv, stock);
                wv.setVerifier(null);
                wv.setStatus(1);
                wvService.updateWV(wv);
                model.addAttribute("msg", "取消审核成功");
                model.addAttribute("wv", wvService.findAll());
            }else{
                model.addAttribute("msg", "库存已出库，无法取消审核");
                model.addAttribute("wv", wvService.findAll());
            }

        } catch (Exception e) {
            model.addAttribute("msg", "取消审核失败");
            model.addAttribute("wv", wvService.findAll());
        }
        return "wv";
    }
    @PostMapping("/update/{id}")
    public String updateView(
            Model model, @PathVariable int id, WV wv) {
//        wv为修改之后的入库单
        try {
            WV realwv = wvService.findByWVId(id);
            /**
             * 若入库单为status=1 保存成功，未提交至库存；status=2 提交完成
             */
            if (realwv.getStatus() == 1) {
                if (realwv.getAmount() == wv.getAmount()) {
                    model.addAttribute("msg", "修改内容前后一致");
                    model.addAttribute("wv", wvService.findAll());
                } else {
                    realwv.setAmount(wv.getAmount());
                    wvService.updateWV(realwv);
                    model.addAttribute("msg", "修改成功");
                    model.addAttribute("wv", wvService.findAll());
                }
            } else if (realwv.getStatus() == 2) {
                model.addAttribute("msg", "该入库单已提交至库存，无法修改");
            }
        } catch (Exception e) {
            model.addAttribute("msg", "修改失败");
            model.addAttribute("wv", wvService.findAll());
        }
        return "wv";
    }
    @GetMapping("/change/{id}")
    public String changeView(
            Model model, @PathVariable int id){
        model.addAttribute("id",id);
        return "wvchange";
    }
}

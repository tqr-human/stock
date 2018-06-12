package cn.stock.controller;

import cn.stock.bean.Goods;
import cn.stock.bean.Stock;
import cn.stock.bean.Unit;
import cn.stock.service.GoodsService;
import cn.stock.service.StockService;
import cn.stock.service.UnitService;
import cn.stock.service.WVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    UnitService unitService;
    @Autowired
    WVService wvService;
    @Autowired
    StockService stockService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String indexView(
            Model model){
        model.addAttribute("goods",goodsService.findAll());
        return "goods";
    }

    @GetMapping("/add")
    public String addView(Model model) {
        model.addAttribute("unit", unitService.findAll());
        return "goodsadd";
    }


    @GetMapping("/delete/{id}")
    public String deleteView(Model model, @PathVariable int id) {
        try {
            Goods goods = goodsService.findById(id);
            Stock stock = stockService.findByStockId(goods.getStock().getId());
            if (stock.getInventory() > 0) {
                model.addAttribute("msg", "该物料有库存，不能删除");
                model.addAttribute("goods", goodsService.findAll());
            }
        } catch (Exception e) {
            try {
                Goods goods = goodsService.findById(id);
                goodsService.deleteGoods(goods);
                model.addAttribute("msg", "删除成功");
                model.addAttribute("goods", goodsService.findAll());
            } catch (Exception ex) {
                model.addAttribute("msg", "删除失败");
                model.addAttribute("goods", goodsService.findAll());
            }
        }

        return "goods";
    }
    @PostMapping("/save")
    public String updateView(
            Model model, Goods goods) {
        try {
            if (goods.getName().equals("") || goods.getName() == null) {
                model.addAttribute("msg", "物料名不能为空");
                model.addAttribute("goods", goodsService.findAll());
                return "goods";
            }
            Unit unit = unitService.findById(goods.getUnitId());
            goods.setUnit(unit);
            goods.setMaxInventory(100);
            goodsService.createGoods(goods);
            model.addAttribute("msg", "新增成功");
            model.addAttribute("goods", goodsService.findAll());
        } catch (Exception e) {
            model.addAttribute("msg", "新增失败");
            model.addAttribute("goods", goodsService.findAll());
            return "goods";
        }
        return "goods";
    }

    @PostMapping("/update/{id}")
    public String updateView(
            Model model, @PathVariable int id, Goods goods) {
        Goods realgoods = goodsService.findById(id);
        int realgoodsMax = realgoods.getMaxInventory();
        if (realgoods.getName().equals(goods.getName())||realgoods.getMaxInventory()==goods.getMaxInventory()) {
            model.addAttribute("msg", "修改内容前后一致");
            model.addAttribute("goods", goodsService.findAll());
        }else
        {
            try {
                if (goods.getMaxInventory()!=null&&!goods.getMaxInventory().equals("")){
                    realgoods.setMaxInventory(goods.getMaxInventory());
                }
                if (!goods.getName().equals("") && goods.getName() != null) {
                    realgoods.setName(goods.getName());
                }
                //            已审核
                if(realgoods.getStock()!=null) {
                    Stock stock = stockService.findByStockId(realgoods.getStock().getId());
                    if (!goods.getName().equals("") && goods.getName() != null)
                    {
                        stock.setName(goods.getName());
                    }
                    if (goods.getMaxInventory()!=null&&!goods.getMaxInventory().equals(""))
                    {
                        if (stock.getInventory() > goods.getMaxInventory()) {
                            realgoods.setMaxInventory(realgoodsMax);
                            model.addAttribute("msg", "修改值不能小于库存内已有数量");
                            model.addAttribute("goods", goodsService.findAll());
                            return "goods";
                        }else {
                            stock.setMax_inventory(goods.getMaxInventory());
                        }
                    }
                    stockService.updateStock(stock);
                }
                    goodsService.updateGoods(realgoods);
                model.addAttribute("msg", "修改成功");
                model.addAttribute("goods", goodsService.findAll());
            } catch (Exception e) {
                model.addAttribute("msg", "修改失败");
                model.addAttribute("goods", goodsService.findAll());
                return "goods";
            }
        }
        return "goods";
    }
    @GetMapping("/change/{id}")
    public String changeView(
            Model model, @PathVariable int id){
        model.addAttribute("id",id);
        return "goodschange";
    }
}

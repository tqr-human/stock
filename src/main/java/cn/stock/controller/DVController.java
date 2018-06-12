package cn.stock.controller;

import cn.stock.bean.DV;
import cn.stock.bean.Stock;
import cn.stock.bean.User;
import cn.stock.service.DVService;
import cn.stock.service.StockService;
import cn.stock.service.Stock_LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/dv")
public class DVController {
    @Autowired
    DVService dvService;
    @Autowired
    StockService stockService;
    @Autowired
    Stock_LogService stockLogService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String indexView(
            Model model){
        model.addAttribute("dv",dvService.findAll());
        return "dv";
    }

    @GetMapping("/add")
    public String addView(Model model) {
        model.addAttribute("stock", stockService.findAll());
        return "dvadd";
    }


    @GetMapping("/delete/{id}")
    public String deleteView(Model model, @PathVariable int id) {
        DV dv = dvService.findByDVId(id);
        if (dv.getStatus() == 2) {
            model.addAttribute("msg", "该出库单已审核，不能删除");
            model.addAttribute("dv", dvService.findAll());
        } else if(dv.getStatus()==1){
            dvService.deleteDV(id);
            model.addAttribute("msg", "删除成功");
            model.addAttribute("dv", dvService.findAll());
        }
        return "dv";
    }
    @PostMapping("/save")
    public String updateView(
            Model model, DV dv) {
        if (dv.getAmount() == null || dv.getAmount().equals("")) {
            model.addAttribute("msg", "出库数不能为空");
            model.addAttribute("dv",dvService.findAll());
            return "dv";
        }
        Date date = new Date();
        Stock stock;
        try {
            stock = stockService.findByStockId(dv.getInventory_id());
            if (stock.getInventory() < dv.getAmount()) {
                model.addAttribute("msg", "库存不足，不能新增该出库单");
                model.addAttribute("dv", dvService.findAll());
            }else {
                dv.setStock(stock);
                dv.setUnit(stock.getUnit());
                dv.setCreated(date);
                dv.setStatus(1);
                dv.setCreater((User) request.getSession().getAttribute("user"));
                dvService.createDV(dv);
                model.addAttribute("msg", "新增成功");
                model.addAttribute("dv", dvService.findAll());
            }
        } catch (Exception e) {
            model.addAttribute("msg", "没有该库存，无法新增该出库单");
            model.addAttribute("dv",dvService.findAll());
            return "dv";
        }
        return "dv";

    }

    @GetMapping("/verify/{id}")
    public String verifyView(Model model, @PathVariable int id) {
        try {
            DV dv = dvService.findByDVId(id);
            Stock stock = stockService.decreaseByDV(dv);
            dv.setStatus(2);
            dv.setVerifier((User) request.getSession().getAttribute("user"));
            dvService.updateDV(dv);
            stockLogService.addByDV(dv, stock);
            model.addAttribute("msg", "审核成功");
            model.addAttribute("dv", dvService.findAll());
        } catch (Exception e) {
            model.addAttribute("msg", "该物料库存不足，审核失败");
            model.addAttribute("dv", dvService.findAll());
        }
        return "dv";
    }

    @GetMapping("/verifydeny/{id}")
    public String verifyDenyView(Model model, @PathVariable int id) {
        try {
            DV dv = dvService.findByDVId(id);
            Stock stock = stockService.findByStockId(dv.getInventory_id());
            int temp = stock.getInventory() + dv.getAmount();
            stock.setInventory(temp);
            stockService.updateStock(stock);
            stockLogService.denyByDV(dv, stock);
            dv.setVerifier(null);
            dv.setStatus(1);
            dvService.updateDV(dv);
            model.addAttribute("msg", "取消审核成功");
            model.addAttribute("dv", dvService.findAll());
        } catch (Exception e) {
            model.addAttribute("msg", "取消审核失败");
            model.addAttribute("dv", dvService.findAll());
        }
        return "dv";
    }

    /**
     * 未修改，有问题
     * @param model
     * @param id
     * @param dv
     * @return
     */
    @PostMapping("/update/{id}")
    public String updateView(
            Model model, @PathVariable int id, DV dv) {
        try {
            DV realdv = dvService.findByDVId(id);
            /**
             * 若入库单为status=1 保存成功，未提交至库存；status=2 提交完成
             */
            if (realdv.getStatus() == 1) {
                if (realdv.getAmount() == dv.getAmount() && realdv.getRemark().equals(dv.getRemark())) {
                    model.addAttribute("msg", "修改内容前后一致");
                    model.addAttribute("dv", dvService.findAll());
                }
//            else if (realdv.getRemark().equals(dv.getRemark())) {
//                model.addAttribute("msg", "修改备注前后一致");
//                model.addAttribute("dv", dvService.findAll());
//            }
                else {
                    if (dv.getRemark() != null&&!dv.getAmount().equals(""))
                        realdv.setAmount(dv.getAmount());
                    realdv.setRemark(dv.getRemark());
                    dvService.updateDV(realdv);
                    model.addAttribute("msg", "修改成功");
                    model.addAttribute("dv", dvService.findAll());
                }
            } else if (realdv.getStatus() == 2) {
                model.addAttribute("msg", "该出库单已提交至库存，无法修改");
                model.addAttribute("dv", dvService.findAll());
            }
        } catch (Exception e) {
            model.addAttribute("msg", "修改失败");
            model.addAttribute("dv", dvService.findAll());
        }
        return "dv";
    }
    @GetMapping("/change/{id}")
    public String changeView(
            Model model, @PathVariable int id){
        model.addAttribute("id",id);
        return "dvchange";
    }
}

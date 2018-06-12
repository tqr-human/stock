package cn.stock.controller;

import cn.stock.bean.Unit;
import cn.stock.service.GoodsService;
import cn.stock.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    UnitService unitService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String indexView(
            Model model){
        model.addAttribute("unit",unitService.findAll());
        return "unit";
    }

    @GetMapping("/add")
    public String addView(Model model) {
        return "unitadd";
    }


    @GetMapping("/delete/{id}")
    public String deleteView(Model model, @PathVariable int id) {
        Unit unit = unitService.findById(id);
        try {
            List goods = goodsService.findByHql("from Goods where unitId = ?", id);
            if (goods.size()!=0) {
                model.addAttribute("msg", "删除失败,有对应物料");
                model.addAttribute("unit", unitService.findAll());
            }else{
                unitService.deleteUnit(unit);
                model.addAttribute("msg", "删除成功");
                model.addAttribute("unit", unitService.findAll());
            }
        } catch (Exception e) {
            try {
                unitService.deleteUnit(unit);
                model.addAttribute("msg", "删除成功");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            } catch (Exception ex) {
                model.addAttribute("msg", "删除失败");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            }
        }
        return "unit";
    }
    @PostMapping("/save")
    public String updateView(
            Model model, Unit unit) {
        try {
            if (unit.getName() == null || unit.getName().equals("")) {
                model.addAttribute("msg", "单位名不能为空");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            }
            Unit runit = unitService.findByName(unit);
            if (runit != null) {
                model.addAttribute("msg", "已有相同名字的单位，无法新增");
                model.addAttribute("unit", unitService.findAll());
            }
        } catch (Exception e) {
            try {
                unitService.createUnit(unit);
                model.addAttribute("msg", "新增成功");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            } catch (Exception ex) {
                model.addAttribute("msg", "新增失败");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            }
        }
        return "unit";
    }

    @PostMapping("/update/{id}")
    public String updateView(
            Model model, @PathVariable int id, Unit unit) {
        Unit realunit = unitService.findById(id);
        try {
            if (unit.getName() == null || unit.getName().equals("")) {
                model.addAttribute("msg", "单位名不能为空");
                model.addAttribute("unit", unitService.findAll());
                return "unit";
            }
            Unit runit = unitService.findByName(unit);
            if (runit != null) {
                model.addAttribute("msg", "已有该名字的单位，无法更新");
                model.addAttribute("unit", unitService.findAll());
            }
        } catch (Exception e) {
            if (realunit.getName().equals(unit.getName())) {
                model.addAttribute("msg", "修改内容前后一致");
                model.addAttribute("unit", unitService.findAll());
            }else
            {
                try {
                    realunit.setName(unit.getName());
                    unitService.updateUnit(realunit);
                    model.addAttribute("msg", "修改成功");
                    model.addAttribute("unit", unitService.findAll());
                    return "unit";
                } catch (Exception ex) {
                    model.addAttribute("msg", "修改失败");
                    model.addAttribute("unit", unitService.findAll());
                    return "unit";
                }
            }

        }
        return "unit";
    }
    @GetMapping("/change/{id}")
    public String changeView(
            Model model, @PathVariable int id){
        model.addAttribute("id",id);
        return "unitchange";
    }
}

package cn.stock.controller;

import cn.stock.bean.Goods;
import cn.stock.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/selector")
@Controller
public class SelectorController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("/")
    public List<Map<String,String>> getUnit(String unit) {
        List<Map<String, String>> results = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        List<Goods> goods;
        goods = goodsService.findByHql("from Goods where unit = ?", unit);
        for (Goods good:goods
             ) {
            map.put("id", good.getId().toString());
            map.put("name", good.getName());
            results.add(map);
            map.clear();
        }
        return results;
    }
//    public String select(Model model,Unit unit) {
//        Map<Integer, String> map = new HashMap<>();
//        map.put(0, "-- Select a Product_Name --");
//        Goods goodx = new Goods();
//        goodx.setId(0);
//        try {
//            List<Goods> goods = goodsService.findByHql("from Goods where unitId = ?", unit.getId());
//            if (goods.size() != 0) {
//                for (Goods good : goods) {
//                    map.put(good.getId(), good.getName());
//                }
//                model.addAttribute("map", map);
//                model.addAttribute("goods", goodx);
//                model.addAttribute("msg", "请选择物料");
//            }
//        } catch (Exception e) {
//            model.addAttribute("msg", "该单位没有对应物料");
//            model.addAttribute("map", map);
//        }
//        return "wvadd";
//    }
}

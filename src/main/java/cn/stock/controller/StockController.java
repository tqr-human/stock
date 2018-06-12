package cn.stock.controller;

import cn.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    StockService stockService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String indexView(Model model) {
        model.addAttribute("stock", stockService.findAll());
        return "stock";
    }

//    @GetMapping("/add")
//    public String addView(Model model) {
//        return "stockadd";
//    }


}

package cn.stock.controller;

import cn.stock.service.Stock_LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/logs")
public class Stock_LogController {
    @Autowired
    Stock_LogService stockLogService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/")
    public String indexView(Model model) {
        model.addAttribute("logs",stockLogService.findAll());
        return "logs";
    }

}

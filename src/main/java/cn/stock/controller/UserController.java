package cn.stock.controller;


import cn.stock.bean.User;
import cn.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest request;


    @GetMapping("/")
    public String indexView(
            Model model){
        model.addAttribute("nowuser", request.getSession().getAttribute("user"));
        model.addAttribute("user",userService.findAll());
        return "user";
    }
    @GetMapping("/add")
    public String addView(
            Model model){
        return "useradd";
    }

    @GetMapping("/change/{id}")
    public String changeView(
            Model model, @PathVariable int id){
        model.addAttribute("id",id);
        return "userchange";
    }
    @GetMapping("/delete/{id}")
    public String deteleView(
            Model model, @PathVariable int id){

        User user=(User)request.getSession().getAttribute("user");
        if (id==user.getId()){
            model.addAttribute("msg","不能删除自己");
            return "user";
        }
        userService.deleteUser(id);
        model.addAttribute("msg","删除成功");
        model.addAttribute("nowuser", request.getSession().getAttribute("user"));
        model.addAttribute("user",userService.findAll());
        return "user";
    }
    @PostMapping("/update/{id}")
    public String updateView(
            Model model, @PathVariable int id,User user){
        User realuser=userService.findByUserId(id);
        if (realuser.getPassword().equals(user.getPassword())) {
            model.addAttribute("msg", "修改密码前后一致");
        }
        else{
            realuser.setPassword(user.getPassword());
            userService.updateUser(realuser);
            model.addAttribute("msg","修改成功");
            model.addAttribute("nowuser", request.getSession().getAttribute("user"));
            model.addAttribute("user",userService.findAll());
        }
        return "user";
    }
    @PostMapping("/save")
    public String updateView(
            Model model, User user){
        userService.createUser(user);
        model.addAttribute("msg","新增成功");
        model.addAttribute("nowuser", request.getSession().getAttribute("user"));
        model.addAttribute("user",userService.findAll());
        return "user";
    }

}

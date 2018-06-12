package cn.stock.controller;

import cn.stock.bean.User;
import cn.stock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/login")
public class HelloWorldController {
	
	@Autowired
	UserService userService;
	@Autowired
	DVService dvService;
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

	@GetMapping("/")
	public String indexView(
			Model model){
		model.addAttribute("stockcount", stockService.count());
		model.addAttribute("logscount", stockLogService.count());
        model.addAttribute("usercount",userService.count());
		model.addAttribute("dvcount", dvService.count());
		model.addAttribute("wvcount", wvService.count());
		model.addAttribute("goodscount", goodsService.count());
		model.addAttribute("unitscount", unitService.count());
		return "index";
	}
	@GetMapping("/login")
	public String loginView(
			Model model){

		return "login";
	}
	@GetMapping("/logout")
	public String logoutView(
			Model model){
        request.getSession().removeAttribute("user");
		return "login";
	}
	@PostMapping("/signin")
	public String signin(Model model,User user){
		try {
			if(user.getPassword()==null||user.getPassword().equals("")){
				model.addAttribute("msg", "密码不能为空");
				return "signin";
			}
			else if (!user.getPassword().equals(user.getPasswordConfirm())) {
				model.addAttribute("msg", "前后密码不一致");
				return "signin";
			}
			else if (userService.findByUserName(new User(user.getUserName())) != null) {
				model.addAttribute("msg", "已存在相同用户名的用户");
				return "signin";
			} else {
				userService.createUser(user);
				model.addAttribute("msg", "用户创建成功");
				request.getSession().setAttribute("user", user);
				return "index";
			}
		} catch (Exception e) {
			userService.createUser(user);
			model.addAttribute("msg", "用户创建成功");
			model.addAttribute("usercount",userService.count());
			model.addAttribute("stockcount", stockService.count());
			model.addAttribute("logscount", stockLogService.count());
			model.addAttribute("dvcount", dvService.count());
			model.addAttribute("wvcount", wvService.count());
			model.addAttribute("goodscount", goodsService.count());
			model.addAttribute("unitscount", unitService.count());
			request.getSession().setAttribute("user",user);
			return "index";
		}
	}

	@GetMapping("/redirect")
	public String redirect(Model model) {
		model.addAttribute("msg", "请填写用户名与密码");
		return "signin";
	}
	@PostMapping("/login")
	public String login(Model model,User user){
        try {
            User loginuser = userService.findByUserName(user);
            if (!loginuser.getPassword().equals(user.getPassword())){
                model.addAttribute("msg","用户名或者密码不正确");
                return "login";
            }else {
				model.addAttribute("usercount",userService.count());
				model.addAttribute("stockcount", stockService.count());
				model.addAttribute("logscount", stockLogService.count());
				model.addAttribute("dvcount", dvService.count());
				model.addAttribute("wvcount", wvService.count());
				model.addAttribute("goodscount", goodsService.count());
				model.addAttribute("unitscount", unitService.count());
				request.getSession().setAttribute("user",loginuser);
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg","用户不存在");
            return "login";
        }
		//转发到index
//        return "redirect:/";
		return "index";
    }
}

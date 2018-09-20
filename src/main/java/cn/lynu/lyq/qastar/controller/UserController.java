package cn.lynu.lyq.qastar.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lynu.lyq.qastar.entity.User;
import cn.lynu.lyq.qastar.misc.JsonResult;
import cn.lynu.lyq.qastar.service.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Resource
	private UserService userService;
	
	/* 添加用户页面 上的添加用户按钮*/
	@PostMapping(value = "/user")
	public void addUser(@RequestBody @Valid User user, BindingResult result) {
		log.debug("add:{}" , user);
		userService.save(user);
	}
	
	/* 登录页面 上的登陆按钮*/
	@PostMapping("/login")
	public JsonResult login(@RequestBody @Valid User user, BindingResult result, HttpSession session) {
		log.debug("login:{}" , user);
		User loginUser = userService.login(user);
		if(loginUser!=null) {
			session.setAttribute("LOGIN_USER", loginUser);
			return new JsonResult("success");
		}else {
			return new JsonResult("fail");
		}
	}
	
	public static void main(String[] args) {

	}

}

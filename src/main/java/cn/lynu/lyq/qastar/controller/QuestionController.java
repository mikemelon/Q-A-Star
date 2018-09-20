package cn.lynu.lyq.qastar.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lynu.lyq.qastar.entity.Question;
import cn.lynu.lyq.qastar.entity.User;
import cn.lynu.lyq.qastar.service.QuestionService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuestionController {
	@Resource
	private QuestionService questionService;
	
	@GetMapping("/questions")
	public List<Question> getAllQuestion(HttpSession session){
		log.debug("获得所有问题");
		log.debug("当前登录用户：{}",(User)session.getAttribute("LOGIN_USER"));
		return questionService.findAll();
	}
	
	/* 添加用户页面 上的添加用户按钮*/
	@PostMapping(value = "/question")
	public void addUser(@RequestBody @Valid Question question, BindingResult result, HttpSession session) {
		log.debug("add:{}" , question);
		User loginUser = (User)session.getAttribute("LOGIN_USER");
		question.setUser(loginUser);
		question.setUpdateTime(new Date());
		questionService.save(question);
	}
	
	public static void main(String[] args) {

	}

}

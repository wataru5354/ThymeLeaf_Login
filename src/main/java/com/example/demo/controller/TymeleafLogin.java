package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.UserForm;

import jakarta.servlet.http.HttpSession;

@Controller
public class TymeleafLogin {

	@ModelAttribute
	public UserForm setUpForm() {
		return new UserForm();
	}
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		String login = (String)session.getAttribute("login");
		if("ok".equals(login)) {
			return "logout";
		}else {
			return "index";
		}
	}
	
	@PostMapping("login")
	public String login(@Validated UserForm userForm,
			BindingResult bindingResult, Model model) {
		
		String message;
		String userName;
		
		if(bindingResult.hasErrors()) {
			message = "何か入力してください";
			model.addAttribute("message",message);
			return "login-ng";
		} if("login123".equals(userForm.getLoginId()) && "1234".equals(userForm.getLoginPassword())){
			session.setAttribute("login", "ok");
			message = "ログインに成功しました。";
			userName = "スクー太郎";
			model.addAttribute("message",message);
			model.addAttribute("userName",userName);
			return "login-ok";
		}else {
			message = "入力内容に誤りがあります。";
			model.addAttribute("message",message);
			return "index";
		}
	}
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate();
		return "index";
	}
	
}

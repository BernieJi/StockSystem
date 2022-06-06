package com.khh.boin.springproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UserRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/loginpage")
	public String loginpage() {
		return "loginpage";
	}
	// 登入成功
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	// 登入失敗
	@PostMapping("/fail")
	@ResponseBody
	public String fail() {
		return "帳密錯誤 請按上一頁重新登入...";
	}
	// 註冊頁面
	@RequestMapping("/registerform")
	public String register() {
		return "register";
	}
	
	// 註冊成功
	@PostMapping("/register")
	public String registerSuccesss(@Valid @ModelAttribute Users users,BindingResult result,Model model) {
		if(result.hasErrors()) return "註冊失敗";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(users.getPassword());
		users.setPassword(encodedPassword);
		userRepository.save(users);
		return "redirect:./loginpage";
	}
	
}

package com.khh.boin.springproject.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.boin.springproject.entity.Message;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	// 登入畫面
	@GetMapping("/loginpage")
	public String loginpage() {
		return "loginpage";
	}
	// 登入成功
	@RequestMapping("/index")
	public String index(@ModelAttribute Users users,Model model) {
		model.addAttribute("users",users);
		return "index";
	}
	// 登入失敗
	@PostMapping("/fail")
	@ResponseBody
	public String fail() {
		return "帳密錯誤 請按上一頁重新登入...";
	}
	
	// 註冊頁面
	@PostMapping("/register")
	public ResponseEntity<Object> registerSuccesss(@Valid @ModelAttribute Users users,BindingResult result,Model model) {
		ResponseEntity<Object> response = null;
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodedPassword = encoder.encode(users.getPassword());
			users.setPassword(encodedPassword);
			// 一般註冊會員authority設定為user
			users.setAuthority("user");
			usersRepository.save(users);
			Message msg = new Message();
			msg.setCode(200);
			msg.setMsg(String.format("此帳號:%s已成功註冊 請按上一頁登入帳號",users.getUsername()));
			response = new ResponseEntity<>(msg, HttpStatus.OK);
		} catch (Exception e) {
			Message msg = new Message();
			msg.setCode(500);
			msg.setMsg(String.format("此帳號:%s已使用過 請按上一頁重新註冊帳號",users.getUsername()));
			response = new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
		}
		return response;
	}
		
}

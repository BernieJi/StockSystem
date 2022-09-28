package com.khh.boin.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.service.UsersService;


@Controller
public class AdminController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersService usersService;
	
	// 列出所有用戶資訊
	@RequestMapping("/index/adminpage")
	public String admin(@ModelAttribute Users users,Model model){
		List<Users> usersz = usersRepository.findAll();
		model.addAttribute("_method","PUT");
		model.addAttribute("usersz",usersz);
		return "adminpage";
		}
	
	// 給予使用者"管理員"權限
	@RequestMapping("/index/adminpage/admin/{usersid}")
	public String authorizeAdmin(@PathVariable("usersid") Integer id){
		Users users = usersRepository.getById(id);
		users.setAuthority("users,admin");
		usersRepository.save(users);
		return "redirect:../";
		}
	
	// 刪除使用者
	@RequestMapping("/index/adminpage/delete")
	public String delete(@RequestParam(value="id") Integer id){
		Users users = usersRepository.getById(id);
		usersRepository.delete(users);
		return "redirect:./";
		}
}

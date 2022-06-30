package com.khh.boin.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.service.UsersService;


@Controller
public class AdminController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/index/adminpage")
	public String admin(@ModelAttribute Users users,Model model){
		List<Users> usersz = usersRepository.findAll();
		model.addAttribute("_method","PUT");
		model.addAttribute("usersz",usersz);
		return "adminpage";
		}
	
	// 刪除用戶
	@RequestMapping("/index/adminpage/delete/{username}")
	public String delete(@PathVariable("username") String username){
		usersService.deleteUsers(username);
		return "redirect:../";
		}
}

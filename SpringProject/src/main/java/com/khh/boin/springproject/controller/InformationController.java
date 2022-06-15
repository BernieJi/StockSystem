package com.khh.boin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UserRepository;

@Controller
public class InformationController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@RequestMapping("index/information")
	public String update(@ModelAttribute Users users,Model model) {
		Users users1 = userRepository.getById(2);
		model.addAttribute("_method","PUT");
		model.addAttribute("users",users1);
		return "information";
	}
	

}

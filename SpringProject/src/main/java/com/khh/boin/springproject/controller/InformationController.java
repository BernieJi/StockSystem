package com.khh.boin.springproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Users;

@Controller
public class InformationController {
	
	@RequestMapping(path="index/information")
	public String update(@ModelAttribute Users users,Model model) {
		model.addAttribute("_method","PUT");
		model.addAttribute("users",users);
		return "information";
	}
	

}

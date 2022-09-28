package com.khh.boin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;


@Controller
public class InformationController {
	@Autowired
	private UsersRepository usersRepository;
		
	@RequestMapping("index/information")
	public String updateInformation(Model model) {
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		Users users = usersRepository.getByUsername(username);
//		model.addAttribute("users",users);
		return "informationtest";
	}
	

}

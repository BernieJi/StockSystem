package com.khh.boin.springproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;


@Controller
public class InformationController {
	@Autowired
	private UsersRepository usersRepository;
		
	@RequestMapping("index/information")
	public String information(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		model.addAttribute("users",users);
		return "information";
	}
	
	@PutMapping("index/information/update/{usersid}")
	public String updateInformation(@PathVariable("usersid")Integer usersid,@RequestBody Users users1) {
		Users users = usersRepository.findById(usersid).get();
		users.setUsername(users1.getUsername());
		users.setEmail(users1.getEmail());
		usersRepository.save(users);
		return "更改成功";
	}
	

}

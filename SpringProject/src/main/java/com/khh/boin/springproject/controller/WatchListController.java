package com.khh.boin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.service.StockService;
import com.khh.boin.springproject.service.UserDetailsServiceImpl;


@Controller
public class WatchListController {
	
	@Autowired
	private StockService stockService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/index/stock/watchlist/{stockcode}")
	public String addWatchList(@PathVariable(value="stockcode",required=true) String stockcode) {
		Stock stock = stockService.getByCode(stockcode);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return "redirect:../";
	}

}

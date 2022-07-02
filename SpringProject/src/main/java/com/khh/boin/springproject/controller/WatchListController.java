package com.khh.boin.springproject.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.boin.springproject.entity.Users;


@Controller
public class WatchListController {
	
	@GetMapping("/index/stock/watchlist")
	@ResponseBody
	public String addWatchList(@AuthenticationPrincipal Users users, @RequestParam(value="stockcode",required=true) String stockcode,Model model) {
		return String.format("股票代號為：%s",stockcode);
	}

}

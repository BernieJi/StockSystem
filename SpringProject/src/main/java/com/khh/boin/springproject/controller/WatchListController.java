package com.khh.boin.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.entity.WatchList;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.repository.WatchListRepository;
import com.khh.boin.springproject.service.StockService;
import com.khh.boin.springproject.service.UserDetailsServiceImpl;


@Controller
public class WatchListController {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private WatchListRepository watchListRepository;
	@Autowired
	private StockService stockService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/index/stock/watchlist/{stockcode}")
	@ResponseBody
	public WatchList addWatchList(@PathVariable("stockcode") String stockcode) {
		Stock stock = stockService.getByCode(stockcode);
		String stockName = stock.getName();
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = new WatchList();
		watchList.setUsers(users);
		watchList.setCode(stockcode);
		watchList.setName(stock.Name);
		watchList.setOpeningPrice(stock.OpeningPrice);
		watchList.setHighestPrice(stock.HighestPrice);
		watchList.setLowestPrice(stock.LowestPrice);
		watchList.setClosingPrice(stock.ClosingPrice);
		watchListRepository.save(watchList);
		return watchList;
	}
	
	@GetMapping("/index/watchlist")
	public String watchList(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = new WatchList();
		watchList.setUsers(users);
		model.addAttribute("users",users);
		model.addAttribute("watchlist",watchList);
		System.out.println(watchList);
		return "watchlist";
	}

}

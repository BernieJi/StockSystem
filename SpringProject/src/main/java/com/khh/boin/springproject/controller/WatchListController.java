package com.khh.boin.springproject.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.entity.WatchList;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.repository.WatchListRepository;
import com.khh.boin.springproject.service.StockService;

@Controller
public class WatchListController {
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private WatchListRepository watchListRepository;
	@Autowired
	private StockService stockService;
	
	// 個股加入追蹤清單頁面
	@GetMapping("/index/stock/watchlist/{stockcode}")
	public String addWatchList(@PathVariable("stockcode") String stockcode) {
		Stock stock = stockService.getByCode(stockcode);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = watchListRepository.getByUsersId(users.getId());
		if(watchList != null) {
			watchList.getStocks().add(stock);
		} 
		else {
		watchList = new WatchList();
		watchList.setUsers(users);
		watchList.getStocks().add(stock);
		}
		watchListRepository.save(watchList);
		return "redirect:../";
	}
	
	// 個人追蹤清單頁面
	@GetMapping("/index/watchlist")
	public String watchList(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = watchListRepository.getByUsersId(users.getId());
		Set<Stock> stocks = watchList.getStocks();
		model.addAttribute("users",users);
		model.addAttribute("stocks",stocks);
		return "watchlist";
	}
	
	// 從個人追蹤清單頁面移除股票
	@GetMapping("/index/watchlist/delete/{stockcode}")
	public String watchList(@PathVariable("stockcode")String stockcode) {
		Stock stock = stockService.getByCode(stockcode);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = watchListRepository.getByUsersId(users.getId());
		watchList.getStocks().remove(stock);
		watchListRepository.save(watchList);
		return "redirect:../";
	}

}

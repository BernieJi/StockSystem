package com.khh.boin.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.StockRepository;
import com.khh.boin.springproject.service.StockService;

@Controller
public class StockController {
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private StockService stockService;
	
	@GetMapping("/index/stock")
	public String stockQuery(@ModelAttribute Stock stock,Users users,Model model) {
	List<Stock> stocks = stockRepository.findAll();
	model.addAttribute("stocks",stocks);
	model.addAttribute("users",users);
	return "stock";
	}
	
	// 根據code查詢單筆
//	@GetMapping("/index/stock/{code}")
//	public String stockGetByCode(@PathVariable("code") String code,Model model) {
//	Stock stock = stockService.getByCode(code);
//	model.addAttribute("stock",stock);
//	return "stock2";
//	}
	
}

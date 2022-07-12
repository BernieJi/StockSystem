package com.khh.boin.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.repository.StockRepository;

@Controller
public class StockInfoController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@RequestMapping("/index/stock/info/{stockcode}")
	public String stockInfo(@PathVariable("stockcode") String stockcode,Model model) {
		Stock stock = stockRepository.getById(stockcode);
		model.addAttribute("stock",stock);
		return "stockInfo";
	}
}

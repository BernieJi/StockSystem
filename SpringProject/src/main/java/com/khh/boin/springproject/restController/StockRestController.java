package com.khh.boin.springproject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.entity.WatchList;
import com.khh.boin.springproject.repository.StockRepository;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.repository.WatchListRepository;
import com.khh.boin.springproject.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "股票Api",description = "關於股票的功能")
@RestController
public class StockRestController {
	
	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private WatchListRepository watchListRepository;
	
	// 查詢所有股票資訊
	@Operation(summary = "查詢所有股票資訊")
	@GetMapping(path="/stockinfo/rawdata/all",produces="application/json")
	public List<Stock> allStocks(){
		List<Stock> stocks = stockRepository.findAll();
		return stocks;
		}
	
	// 根據stockCode查詢股票資訊
	@Operation(summary = "根據stockCode查詢股票資訊")
	@GetMapping(path="/stockinfo/rawdata/{stockcode}",produces="application/json")
	public Stock stockQueryByStockCode(@PathVariable("stockcode")String stockcode){
		Stock stock = stockRepository.getByCode(stockcode);
		return stock;	 
	}
	
	// 將此檔股票加入追蹤清單
	// 個股加入追蹤清單頁面
	@Operation(summary = "根據stockCode將股票加入追蹤清單")
	@PostMapping("/stockinfo/rawdata/{stockcode}/addtowatchlist")
	public String addToWatchList(@PathVariable("stockcode") String stockcode) {
		Stock stock = stockRepository.getByCode(stockcode);
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Users users = usersRepository.getByUsername(username);
		WatchList watchList = watchListRepository.getByUsersId(users.getId());
		if(watchList != null) {
			watchList.getStocks().add(stock);
		} else {
			watchList = new WatchList();
			watchList.setUsers(users);
			watchList.getStocks().add(stock);
		}
		watchListRepository.save(watchList);
		return "加入追蹤成功";
		}
	
	// 刪除股票
	@Operation(summary = "刪除股票")
	@DeleteMapping("/stockinfo/rawdata/{stockcode}/delete")
	public String delete(@PathVariable(value="stockcode") String stockcode){
		Stock stock = stockRepository.getByCode(stockcode);
		stockRepository.delete(stock);
		return "redirect:./";
		}
}


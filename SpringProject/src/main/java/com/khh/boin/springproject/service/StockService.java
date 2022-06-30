package com.khh.boin.springproject.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;
	
	// 查詢所有stock資訊
	public Iterable<Stock> list(){
		return stockRepository.findAll();
	}
	
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}
	
	public Iterable<Stock> save(List<Stock> stocks){
		return stockRepository.saveAll(stocks);
	}
	
	List<Stock> stocks = new CopyOnWriteArrayList();
	
	// 根據Code查詢單檔股票
	public Stock getByCode(String code) {
		Optional<Stock> optStock = stockRepository.findAll().stream()
				.filter(s->s.Code.equals(code))
				.findFirst();
		return optStock.isPresent()?optStock.get():null;
	}
	
	// 將單檔股票存入追蹤名單

	
}

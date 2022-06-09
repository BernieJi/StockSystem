package com.khh.boin.springproject.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khh.boin.springproject.entity.Stock;

@RestController
public class StockController {
	
	@GetMapping(path="/index/stock",produces="application/json;charset=UTF-8")
	public List<Stock> stockQuery() {
	// HttpClient物件
	CloseableHttpClient client = HttpClients.createDefault();
	// stock url
	String stockURL = "https://openapi.twse.com.tw/v1/exchangeReport/STOCK_DAY_ALL";
	// 建構一個 HttpGet物件
	HttpGet get = new HttpGet(stockURL);
	List<Stock> data = null;
	// 正式提出請求
	try {
		// 提出請求 接回來Response物件（URL/Header/Body--HttpEntity)
		CloseableHttpResponse response = client.execute(get);
		// 讀取回應的結果Json
		// 取出回應的內容
		InputStream is = response.getEntity().getContent();
		InputStreamReader reader = new InputStreamReader(is,"UTF-8");
		// 即使讀取到字串 目的要反序列化成可操作的物件
		// 如何將Json反序列化成可以操作的集合物件 
		// Gson 個體物件
		Gson gson = new Gson();
		Type listType = new TypeToken<List<Stock>>(){}.getType();
		data = gson.fromJson(reader, listType);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	// 對外(Ubike Open Data)服務進行串接
		
	// 查詢結果序列化回應
	return data;
	}
}
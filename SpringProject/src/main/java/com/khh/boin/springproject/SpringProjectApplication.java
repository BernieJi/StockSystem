package com.khh.boin.springproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.service.StockService;

@SpringBootApplication
@RestController
public class SpringProjectApplication {
	
	@GetMapping("/message")
	public String message() {
		return "Hello";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StockService stockService) {
		return args -> {
			CloseableHttpClient client = HttpClients.createDefault();
			String stockURL = "https://openapi.twse.com.tw/v1/exchangeReport/STOCK_DAY_ALL";
			HttpGet get = new HttpGet(stockURL);
			List<Stock> stocks = null;
			try {
				CloseableHttpResponse response = client.execute(get);
				// 回應的結果Json
				// 取出回應的內容(Http header/body)
			    InputStream is = response.getEntity().getContent(); 
				InputStreamReader reader = new InputStreamReader(is,"UTF-8");
				// 即使讀取到字串 目的要反序列化成可操作的物件
				// 如何將Json反序列化成可以操作的集合物件 
				// Gson 個體物件
				Gson gson = new Gson();
				Type listType = new TypeToken<List<Stock>>(){}.getType();
				stocks = gson.fromJson(reader, listType);
				stockService.save(stocks);
				System.out.println("success!");
				} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to save stocks:" + e.getMessage());
				}
		};
	}
}
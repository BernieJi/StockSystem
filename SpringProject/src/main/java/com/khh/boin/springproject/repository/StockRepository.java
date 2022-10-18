package com.khh.boin.springproject.repository;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.khh.boin.springproject.entity.Stock;
import com.khh.boin.springproject.entity.Users;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {
	
	@Query(value = "SELECT * from stock where stock.code = ?1", nativeQuery = true)
	Stock getByCode(String code);
		
}

package com.khh.boin.springproject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.entity.WatchList;
import com.khh.boin.springproject.repository.WatchListRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "關注列表Api",description = "關於關注列表的功能")
@RestController
public class WatchListRestController {

	@Autowired
	private WatchListRepository watchListRepository;
	
	// 查詢所有關注列表資訊
	@Operation(summary = "查詢所有關注列表的資訊")
	@GetMapping(path="/watchlistinfo/rawdata/all",produces="application/json")
	public List<WatchList> allWatchList(){
		List<WatchList> watchLists = watchListRepository.findAll();
		return watchLists;
	}
	

	
}

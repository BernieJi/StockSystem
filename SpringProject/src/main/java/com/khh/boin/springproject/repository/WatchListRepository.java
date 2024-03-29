package com.khh.boin.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.entity.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, Integer> {
	
	WatchList getByUsersId(Integer id);

		
	}
	
	


package com.khh.boin.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khh.boin.springproject.entity.WatchList;

public interface WatchListRepository extends JpaRepository<WatchList, Integer> {

}

package com.khh.boin.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
// @Table
@Entity
public class Stock {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO) // 自動新增
		public int id;
	 	//@Column
	    public String Code;
	 	//@Column
	    public String Name;
	 	//@Column
	    public String TradeVolume;
	    //@Column
	    public String TradeValue;
	    //@Column
	    public String OpeningPrice;
	    //@Column
	    public String HighestPrice;
	    //@Column
	    public String LowestPrice;
	    //@Column
	    public String ClosingPrice;
	    //@Column
	    public String Change;
	    //@Column
	    public String Transaction;
	}


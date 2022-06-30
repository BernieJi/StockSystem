package com.khh.boin.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity

public class Stock {
	
		@Id
	    public String Code;
	 	
	    public String Name;
	 
	    public String TradeVolume;
	   
	    public String TradeValue;
	    
	    public String OpeningPrice;
	    
	    public String HighestPrice;
	    
	    public String LowestPrice;
	    
	    public String ClosingPrice;
	    
	    @Column(name="stock_change")
	    public String Change;
	    
	    @Column(name="stock_transaction")
	    public String Transaction;
	}


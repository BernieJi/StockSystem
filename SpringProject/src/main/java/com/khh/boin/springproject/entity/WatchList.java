package com.khh.boin.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="watch_list")
public class WatchList {

	@Id
	@SequenceGenerator(
			name="watch_list_sequence",
			sequenceName = "watch_list_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "watch_list_sequence"
			)
	public Integer wid;
	
	public Integer id;
	public String username;
	@Column(
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
	public String stockCode;
	@Column(
            nullable = false,
            unique = true,
            columnDefinition = "TEXT"
    )
	public String stockName;
	
	public String openingPrice;
    
    public String highestPrice;
    
    public String lowestPrice;
    
    public String closingPrice;
    
    public WatchList() {
		
	}
    
	public WatchList(Integer wid, Integer id, String username,String stockCode, String stockName, String openingPrice,
			String highestPrice, String lowestPrice, String closingPrice) {
		this.wid = wid;
		this.id = id;
		this.username=username;
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.openingPrice = openingPrice;
		this.highestPrice = highestPrice;
		this.lowestPrice = lowestPrice;
		this.closingPrice = closingPrice;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStockCode() {
		return stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getOpeningPrice() {
		return openingPrice;
	}

	public void setOpeningPrice(String openingPrice) {
		this.openingPrice = openingPrice;
	}

	public String getHighestPrice() {
		return highestPrice;
	}

	public void setHighestPrice(String highestPrice) {
		this.highestPrice = highestPrice;
	}

	public String getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public String getClosingPrice() {
		return closingPrice;
	}

	public void setClosingPrice(String closingPrice) {
		this.closingPrice = closingPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
    
}

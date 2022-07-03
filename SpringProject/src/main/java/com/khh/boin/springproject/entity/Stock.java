package com.khh.boin.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


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

		public String getCode() {
			return Code;
		}

		public void setCode(String code) {
			Code = code;
		}

		public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public String getTradeVolume() {
			return TradeVolume;
		}

		public void setTradeVolume(String tradeVolume) {
			TradeVolume = tradeVolume;
		}

		public String getTradeValue() {
			return TradeValue;
		}

		public void setTradeValue(String tradeValue) {
			TradeValue = tradeValue;
		}

		public String getOpeningPrice() {
			return OpeningPrice;
		}

		public void setOpeningPrice(String openingPrice) {
			OpeningPrice = openingPrice;
		}

		public String getHighestPrice() {
			return HighestPrice;
		}

		public void setHighestPrice(String highestPrice) {
			HighestPrice = highestPrice;
		}

		public String getLowestPrice() {
			return LowestPrice;
		}

		public void setLowestPrice(String lowestPrice) {
			LowestPrice = lowestPrice;
		}

		public String getClosingPrice() {
			return ClosingPrice;
		}

		public void setClosingPrice(String closingPrice) {
			ClosingPrice = closingPrice;
		}

		public String getChange() {
			return Change;
		}

		public void setChange(String change) {
			Change = change;
		}

		public String getTransaction() {
			return Transaction;
		}

		public void setTransaction(String transaction) {
			Transaction = transaction;
		}

		@Override
		public String toString() {
			return "Stock [Code=" + Code + ", Name=" + Name + ", TradeVolume=" + TradeVolume + ", TradeValue="
					+ TradeValue + ", OpeningPrice=" + OpeningPrice + ", HighestPrice=" + HighestPrice
					+ ", LowestPrice=" + LowestPrice + ", ClosingPrice=" + ClosingPrice + ", Change=" + Change
					+ ", Transaction=" + Transaction + "]";
		}
	    
	    
	    
	}


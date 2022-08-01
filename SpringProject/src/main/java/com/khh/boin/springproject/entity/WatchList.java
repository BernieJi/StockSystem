package com.khh.boin.springproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(targetEntity = Users.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customerid")
	public Users users;
    
	public String Code;
 	
    public String Name;
    
    public String OpeningPrice;
    
    public String HighestPrice;
    
    public String LowestPrice;
    
    public String ClosingPrice;
    
    @ManyToMany
    @JoinTable(name="stock_watchList",
    	joinColumns = {@JoinColumn(name="watchList_id",referencedColumnName = "wid")},
    	inverseJoinColumns = {@JoinColumn(name="stock_id",referencedColumnName = "code")})
    public List<Stock> stocks;
    
    public WatchList() {
		
	}
    
	public WatchList(Integer wid, Users users, String code, String name, String openingPrice, String highestPrice,
			String lowestPrice, String closingPrice, List<Stock> stocks) {
		this.wid = wid;
		this.users = users;
		Code = code;
		Name = name;
		OpeningPrice = openingPrice;
		HighestPrice = highestPrice;
		LowestPrice = lowestPrice;
		ClosingPrice = closingPrice;
		this.stocks = stocks;
	}



	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

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

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "WatchList [wid=" + wid + ", users=" + users + ", Code=" + Code + ", Name=" + Name + ", OpeningPrice="
				+ OpeningPrice + ", HighestPrice=" + HighestPrice + ", LowestPrice=" + LowestPrice + ", ClosingPrice="
				+ ClosingPrice + ", stocks=" + stocks + "]";
	}
    
	
	
    
}

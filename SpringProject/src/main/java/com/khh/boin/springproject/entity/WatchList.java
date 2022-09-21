package com.khh.boin.springproject.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="watch_list")
public class WatchList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer wid;
	
	@OneToOne(mappedBy = "watchlist")
	public Users users;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="watchlist_stock",
				joinColumns = {@JoinColumn(name="watchList_id",referencedColumnName = "wid")},
				inverseJoinColumns = {@JoinColumn(name="stock_id",referencedColumnName = "Code")})
    public Set<Stock> stocks = new HashSet<>();
	
	public WatchList() {
		
	}

	public WatchList(Integer wid, Users users, Set<Stock> stocks) {
		super();
		this.wid = wid;
		this.users = users;
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

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "WatchList [wid=" + wid + ", users=" + users + ", stocks=" + stocks + "]";
	}
	
	

    
}

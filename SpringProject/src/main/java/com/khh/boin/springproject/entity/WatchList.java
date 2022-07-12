package com.khh.boin.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
//	@ManyToOne
//	@JoinColumn(name = "users_id")
//	public Users users;
    
    public WatchList() {
		
	}
    
	public WatchList(Integer wid) {
		this.wid = wid;
	}

	public Integer getWid() {
		return wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}	
    
}

package com.khh.boin.springproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	@SequenceGenerator(
			name="users_sequence",
			sequenceName = "users_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "users_sequence"
			)
	public Integer id;
	
	public String username;
	
	public String password;
	
	public String email;
	
	public String authority;
	
	@OneToMany(targetEntity = WatchList.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_customerid",referencedColumnName = "id")
	public List<WatchList> watchlists;
	
	public Users() {

	}
	
	public Users(Integer id, String username, String password, String email, String authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.authority = authority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", authority=" + authority + "]";
	}
	
	
	
}

package com.khh.boin.springproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
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
	
	@Size(min = 2,max = 50,message = "{user.username.size}")
	@NotEmpty(message = "{user.username.empty}")
	public String username;
	
	@NotEmpty(message = "{user.password.empty}")
	public String password;
	
	@Size(min = 2,max = 50,message = "{user.email.size}")
	@NotEmpty(message = "{user.email.empty}")
	public String email;
	
	public String authority;

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

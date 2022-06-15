package com.khh.boin.springproject.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.khh.boin.springproject.entity.Users;

//@Repository
//public class UserDao implements UserRepository {
public class UserDao {
	
	//@Autowired
	private JdbcTemplate jdbcTemplate;

	//@Override
	// 根據username來查詢資料庫
	public Users getByName(String username) {
		String sql = "select id,username,password,email from users where username = ?"; 
		return jdbcTemplate.queryForObject(sql, (ResultSet rs,int i) ->{
		  Users users = new Users();
		  users.setId(rs.getInt("id"));
		  users.setUsername(rs.getString("username"));
		  users.setPassword(rs.getString("password"));
		  users.setEmail(rs.getString("email"));
		  return users;
		});
	}
}

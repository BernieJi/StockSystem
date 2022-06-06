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
	public List<Users> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Users> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Users> findAllById(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public <S extends Users> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void deleteAllInBatch(Iterable<Users> entities) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void deleteAllByIdInBatch(Iterable<Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public Users getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Users getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public <S extends Users> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public <S extends Users, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Page<Users> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public <S extends Users> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Optional<Users> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public boolean existsById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	//@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void delete(Users entity) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void deleteAll(Iterable<? extends Users> entities) {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

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

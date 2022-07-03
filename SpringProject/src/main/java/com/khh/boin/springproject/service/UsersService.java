package com.khh.boin.springproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	// 查詢所有用戶
	public List<Users> queryAll(){
		return usersRepository.findAll();
	}
	
	// 修改用戶資料
	public Boolean updateUsers(Integer id,Users users) {
		usersRepository.save(users);
		return true;
	}
	
	// 刪除用戶資料
	public Boolean deleteUsers(Integer id) {
		usersRepository.delete(usersRepository.getById(id));
		return true;
	}	
}

package com.khh.boin.springproject.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	List<Users> usersz = new CopyOnWriteArrayList<>();
	
	// 查詢所有用戶
	public List<Users> queryAll(){
		return usersz;
	}	
	
	// 修改用戶資料
	public Boolean updateUsers(String username,Users users) {
		usersRepository.save(users);
		return true;
	}
	
	// 刪除用戶資料
	public Boolean deleteUsers(String username) {
		usersRepository.delete(usersRepository.getByUsername(username));
		return true;
	}	
}

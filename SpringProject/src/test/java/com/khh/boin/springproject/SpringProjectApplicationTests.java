package com.khh.boin.springproject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;

class SpringProjectApplicationTests {

	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	public void queryAllUsersz() {
		Users users1 = usersRepository.getByUsername("boin");
		System.out.println(users1);
	}
}

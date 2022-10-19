package com.khh.boin.springproject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "管理員Api",description = "關於管理員的功能")
@RestController
public class AdminRestController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	// 列出所有用戶資訊
	@Operation(summary = "列出所有Users資訊")
	@GetMapping("/admininfo/rawdata/all")
	public List<Users> allUsers(){
		List<Users> usersz = usersRepository.findAll();
		return usersz;
		}
		
	// 根據username給予使用者"管理員"權限
	@Operation(summary = "根據username給予使用者admin權限")
	@PutMapping("/admininfo/rawdata/{username}/giveauthority")
	public String authorizeAdmin(@PathVariable("username") String username){
		Users users = usersRepository.getByUsername(username);
		users.setAuthority("users,admin");
		usersRepository.save(users);
		return "授予權限成功";
		}
		
	// 根據username刪除使用者
	@Operation(summary = "根據username刪除使用者")
	@DeleteMapping("/admininfo/rawdata/{username}/deleteuser")
	public String deleteUser(@PathVariable("username") String username){
		Users users = usersRepository.getByUsername(username);
		usersRepository.delete(users);
		return "User刪除成功";
		}
}

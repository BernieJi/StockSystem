package com.khh.boin.springproject.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khh.boin.springproject.entity.Users;
import com.khh.boin.springproject.repository.UsersRepository;
import com.khh.boin.springproject.service.UsersService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "使用者Api",description = "關於使用者的功能")
@RestController
public class UsersRestController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private UsersService usersService;
	
	// 查詢所有用戶資訊
	@Operation(summary = "查詢所有用戶的資訊")
	@GetMapping(path="/usersinfo/rawdata/all",produces="application/json")
	public List<Users> allUsers(){
		List<Users> usersz = usersRepository.findAll();
		return usersz;
		}
	
	// 根據usersName查詢用戶資訊
	@Operation(summary = "根據usersName查詢用戶資訊")
	@GetMapping(path="/usersinfo/rawdata/{usersname}",produces="application/json")
	public Users usersQueryByUserName(@PathVariable("usersname")String username){
		Users users = usersRepository.getByUsername(username);
		return users;	 
	}
	
	// 修改用戶資料
	@PutMapping(path="/usersinfo/rawdata/{usersname}/update",consumes="application/json")
	public String update(@PathVariable(value="usersname") String username,@RequestBody Users usersUpdate){
		Users users = usersRepository.getByUsername(username);
		users.setUsername(usersUpdate.getUsername());
		users.setEmail(usersUpdate.getEmail());
		usersRepository.save(users);
		return "update success!";
	}
	
	// 刪除用戶
	@Operation(summary = "刪除使用者")
	@DeleteMapping("/usersinfo/rawdata/{usersid}/delete")
	public String delete(@PathVariable(value="usersid") Integer id){
		usersService.deleteUsers(id);
		return "redirect:./";
		}
}


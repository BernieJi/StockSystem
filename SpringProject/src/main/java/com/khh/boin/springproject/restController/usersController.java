//package com.khh.boin.springproject.restController;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.khh.boin.springproject.entity.Users;
//import com.khh.boin.springproject.repository.UsersRepository;
//import com.khh.boin.springproject.service.UsersService;
//
//
//@RestController
//public class usersController {
//	
//	@Autowired
//	private UsersRepository usersRepository;
//	
//	@Autowired
//	private UsersService usersService;
//	
//	// 查詢所有用戶資訊
//	@RequestMapping(path="/usersinfo/rawdata/all",produces="application/json")
//	public List<Users> allUsers(){
//		List<Users> usersz = usersRepository.findAll();
//		return usersz;
//		}
//	
//	// 根據usersName查詢用戶資訊
//	@GetMapping(path="/usersinfo/rawdata/{usersname}",produces="application/json")
//	public ResponseEntity<Object> usersQueryById(@PathVariable("usersname")String username){
//			
//				Users users = usersRepository.getByUsername(username);
//				return new ResponseEntity<>(users,HttpStatus.OK);
//		 
//	}
//	
//	// 刪除用戶
//	@DeleteMapping("/usersinfo/rawdata/{usersid}/delete")
//	public String delete(@RequestParam(value="id") Integer id){
//		usersService.deleteUsers(id);
//		return "redirect:./";
//		}
//}


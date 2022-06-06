package com.khh.boin.springproject.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.khh.boin.springproject.entity.Users;

/*
方法命名規則：https://blog.csdn.net/sbin456/article/details/53304148
1. 查詢方法以 find | read | get 開頭
2. 涉及條件查詢時，條件的屬性(首字母大寫)用條件關鍵字連結
3. 若要使用集聯屬性，則屬性之間使用 _ 進行連結
*/

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	Users getByUsername(String username);
			
}

package com.khh.boin.springproject;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

class SpringProjectApplicationTests {
	
	public static void main(String[] args) {		
		PasswordEncoder pe = new BCryptPasswordEncoder();
		String ecode = pe.encode("1234");
		// 儲存在資料庫的是ecode
		System.out.println(ecode);
		boolean matches = pe.matches("1234",ecode);
		System.out.println(matches);
		
	}

}

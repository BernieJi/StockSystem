package com.khh.boin.springproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.khh.boin.springproject.handle.MyAccessDeniedHandler;
import com.khh.boin.springproject.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private MyAccessDeniedHandler myAccessDeniedHandler;
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 表單提交
		http.formLogin()
			// loginpage.html 表單 action 內容
			.loginProcessingUrl("/index")
			// 自定義的登入頁面
			.loginPage("/loginpage")
			// 登入成功後造訪的頁面
			//.defaultSuccessUrl("/", true)  // 只可以GET // welcome 頁面
			.successForwardUrl("/index")     // 只可以POST
			// 登入失敗後造訪的頁面
			.failureForwardUrl("/fail");
		
		// 授權認證
		String[] permitted = {"/loginpage","/register","/css/**","/images/**","/js/**","/usersinfo/**"};
		http.authorizeHttpRequests()
        // 不需要被認證的頁面：/loginpage,/registerform 與資源檔
        .antMatchers(permitted).permitAll()
        // 權限判斷
        // 必須要有 admin權限才可以訪問
        .antMatchers("/adminpage").hasAuthority("admin")
        // 必須要有manager角色才可以訪問
        //.antMatchers("/managerpage").hasRole("manager")
        // 其他指定任意角色都可以訪問
        //.antMatchers("/employeepage").hasAnyRole("manager","employee")
        // 其他的都要被認證
        .anyRequest().authenticated();
		
        // 關閉 csrf 防護
        http.csrf().disable();
        
        // 登出設置
        http.logout()
        	.deleteCookies("JESSIONID")
        	.logoutSuccessUrl("/loginpage")
        	// 可以使用任何的HTTP方法登出
        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout")); 
        
        // 異常處理
        http.exceptionHandling()
        	// 有兩種處理方式(二擇一）
        	//.accessDeniedPage("/errorpage")
        	.accessDeniedHandler(myAccessDeniedHandler);
        
        // remember-me
        http.rememberMe()
        	.userDetailsService(userDetailsService)
        	.tokenValiditySeconds(60 * 60 * 3); // 通常都會大於 session timeout的時間(30mins)
	}

}

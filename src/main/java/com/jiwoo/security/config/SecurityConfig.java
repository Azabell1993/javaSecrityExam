package com.jiwoo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity // 이 클래스는 보안과 관련된 인증과 인가에 대한 정보를 담고 있는 클래스임을 나타내는 anoo
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BoardUserDetailService boardUserDetailService;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		security.authorizeHttpRequests()
				.antMatchers("/")
				.permitAll();
		
		security.authorizeHttpRequests()
				.antMatchers("/member/**")
				.authenticated(); /* login 성공만 하면 사용할 수 있는 범위 설정 메서드??? */
		
		security.authorizeHttpRequests()
				.antMatchers("/manager/**")
				.hasRole("ROLE_MANAGER");
				
		security.authorizeHttpRequests()
				.antMatchers("/admin/**")
				.hasRole("ROLE_ADMIN");

		security.csrf().disable();
		
		// 로그인 페이지로 연결
		security.formLogin();/*기본 내장 로그인 품 */
		//        .loginPage("/login")/* 사용자 지정 로그인 품으로 지정  */.defaultSuccessUrl("/loginSuccess", true);
		security.exceptionHandling().accessDeniedPage("/accessDenied");
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login");
		
		//security.userDetailsService(boardUserDetailService);
	}
}

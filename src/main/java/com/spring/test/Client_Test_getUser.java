package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardService;
import com.spring.users.UserDTO;
import com.spring.users.UserService;

public class Client_Test_getUser {

	public static void main(String[] args) {
	
		
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 스프링 컨테이너로 부터 Bean 을 호출 : UserService : 인터페이스 
		UserService userService =(UserService) factory.getBean("userService"); 
		
		UserDTO userDTO = new UserDTO(); 
		userDTO.setId("admin");
		userDTO.setPassword("1234");
		
		//service 인터페이스 메소드 호출시 리턴으로 UserDTO 
		UserDTO user = userService.getUser(userDTO); 
		
		System.out.println(user);
		
		
		
	}

}

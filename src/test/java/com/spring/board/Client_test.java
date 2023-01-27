package com.spring.board;

import java.sql.Connection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.common.JDBCUtil;

import polimorphism05.TV;

public class Client_test {

	public static void main(String[] args) {
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		Connection conn = null; 
		JDBCUtil db = new JDBCUtil(); 
		
		conn = JDBCUtil.getConnection(); 

	}

}

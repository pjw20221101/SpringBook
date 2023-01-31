package com.spring.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.board.BoardDTO;
import com.spring.board.BoardService;

public class Client_Test_delete {

	public static void main(String[] args) {
	
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");

		// 스프링 컨테이너로 부터 Bean 을 호출 : BoardService : 인터페이스 
		BoardService boardService =(BoardService) factory.getBean("boardService"); 
		
		//DTO 객체를 생성후에 Setter 주입으로 DTO 각 필드의 값을 입력 
		BoardDTO boardDTO = new BoardDTO(); 
		
		//deleteBoard() 메소드 테스트 
		
		//DTO에 seq 컬럼의 값을 할당후 deleteBoard(dto) 메소드 호출
		boardDTO.setSeq(4);
		
		//deleteBoard(boardDTO) 
		boardService.deleteBoard(boardDTO);
		
	}

}

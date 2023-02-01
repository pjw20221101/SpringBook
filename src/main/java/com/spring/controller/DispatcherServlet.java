package com.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.board.BoardDAO;
import com.spring.board.BoardDTO;
import com.spring.users.UserDAO;
import com.spring.users.UserDTO;
import com.spring.users.UserService;
import com.spring.users.UserServiceImpl;

/**
 * Servlet implementation class DispatcherServlet
 */
//@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DispatcherServlet() {
        super();
     
    }

    //doGet���� �Ѿ���� ��û�� process () �޼ҵ忡�� ó�� �ϵ��� �ѱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		process(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Post ������� ������ ���� �ѱ涧 �ѱ� ������ ���� ó�� 
		request.setCharacterEncoding("UTF-8");
		process(request, response); 

	}
	
	// doGet, doPost �� ��� ��û�� ó�� �ϴ� �޼ҵ� 
	private void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// URL : http://localhost:8080/boardweb/getBoardList.do 
		// URI : /boardweb/getBoardList.do
		
		
		//1. Ŭ���̾�Ʈ�� ��û path ������ ���� �Ѵ�. 
		

		String url = request.getRequestURL().toString();   //URL ������ �Դ��� .toString()
		System.out.println(url);
			
		String uri = request.getRequestURI(); 		///boardweb/getBoardList.do
			System.out.println("uri : " + uri);
		
		String path = uri.substring(uri.lastIndexOf("/"));  //getBoardList.do
			System.out.println("path : "+ path);
		
		
		//2. Ŭ���̾�Ʈ�� ��û ������ ���� �����ϰ� �б� ó����. 
		
		if (path.equals("/login.do")) {
			
			// Ŭ���̾�Ʈ ��û�� ���ؼ� : /loin.do ��û 
			//1. Model : Service (����Ͻ� ������ ó��)  , (DTO, DAO) 
			//2. View �������� ���� : *.jsp ����
						
			System.out.println("����� ���� ó��");
			System.out.println("/login.do ��û�� ���½��ϴ�. ");
			
			// 1. Ŭ���̾�Ʈ���� ������ ���� ���� �޾Ƽ� ������ ���� 
			String id = request.getParameter("id"); 
			String password = request.getParameter("password"); 
			
			System.out.println("������ �ѱ� ���� id �� ��� : " + id);
			System.out.println("������ �ѱ� ���� id �� ��� : " + password);
			
			//2. Ŭ���̾�Ʈ���� �ѱ� �������� �޾Ƽ� ����� ������ DTO�� Setter ���� 
			UserDTO dto = new UserDTO(); 
			dto.setId(id); 
			dto.setPassword(password); 
			
			//3. ����Ͻ� ������ ó���ϴ� �������̽��� dto�� ���� �ؼ� ����Ͻ� ������ ó��
			
			//UserService user = new UserServiceImpl(); 
			UserDAO user = new UserDAO(); 
			
			UserDTO userD = user.getUser(dto); 
			
			//DB�� Ŭ���̾�Ʈ���� �ѱ� ID �� Password �� select �ؼ� �ׁ��� DTO�� ��Ƽ� ���� 
			System.out.println(userD);
			
			
			//4. �鿣���� ������ ��� ó���� View �������� �̵� 
			if (userD != null) {  //Ŭ���̾�Ʈ���� ������ ID �� Pass�� DB�� ���� ��ġ �Ҷ�
				response.sendRedirect("getBoardList.do"); 
				System.out.println("���̵�� �н����� ��ġ");
			}else {  //Client���� ������ ID�� Pass�� ��ġ���� ���� ��  
				response.sendRedirect("login.jsp"); 
				System.out.println("���̵�� �н����� ����ġ ");
			}
					
			
		}else if (path.equals("/getBoardList.do")) {
			System.out.println("�Խ��� ���� ��� ");
			
			//1. Client �� ���� /getBoardList.do ��û�� ����. (�Խ��� ������ ����� �޶�� ��û )  
			
			//2. ����Ͻ� ���� ó�� 
			BoardDTO dto = new BoardDTO(); 
			BoardDAO dao = new BoardDAO(); 
			
			//boardList ���� DB���� ������ ���ڵ带 ���� DTO ��ü�� ����Ǿ� �ִ�. 
			List<BoardDTO> boardList = dao.getBoardList(dto); 
			
			//3. Ŭ���̾�Ʈ���� boardList�� �����ؾ� �Ѵ�. 
			//(���� ��ü�� boardList ��ü�� ��Ƽ� ���� ��Ŵ
			// ������ ������ RAM�� �����. 
			// ��Ű : Ŭ���̾�Ʈ �ý����� HDD �� ������ ������. 
			HttpSession session = request.getSession(); 
			//session ��ü�� ���� ���� , setAttribute("������", ��ü );
			//session ��ü�� ���� ������ö�, getAttribute("������");                       
			session.setAttribute("boardList", boardList); 
			
			
			//4. ���������� �̵� 
			response.sendRedirect("getBoardList.jsp"); 
			
			
		}else if (path.equals("/insertBoard.do")) {
			
			System.out.println("board ���̺��� ���� ����");
			//1. Ŭ���̾�Ʈ���� �Ѿ���� ���� ���� �޾Ƽ� ���ο� ������ ���� 
			String title = request.getParameter("title"); 
			String writer = request.getParameter("writer"); 
			String content = request.getParameter("content"); 
			
			//2.  ����Ͻ� ���� ó��  (Ŭ���̾�Ʈ�� ������ dto �� ������ dao�� insertBoard(dto) 
			BoardDTO dto = new BoardDTO(); 
			BoardDAO dao = new BoardDAO(); 
			
				//dto �� setter �޼ҵ� ȣ��� Ŭ���̾�Ʈ���� �Ѿ��� ������ �Ҵ�. 
			dto.setTitle(title); 
			dto.setWriter(writer); 
			dto.setContent(content); 
			
			dao.insertBoard(dto); 	//DB �� Insert/ Update /delete  �� �Ϸ�� 
			
			//3. view �������� ���� 
			response.sendRedirect("getBoardList.do");  
			
			
		}else if (path.equals("/getBoard.do")) {
			
			System.out.println("�Խ��� �� ���뺸�� - /getBoard.do ��û��");	
			
			//1. Ŭ���̾�Ʈ�� �ѱ� ���� �� �ޱ� ("seq") 
			String seq = request.getParameter("seq");    //getParameter �� �Ѿ���� ���� ��� String
			System.out.println("seq ������ : " + seq);
			
			//2. ����Ͻ� ���� ó�� : �Ķ���ͷ� ���� ���� DTO�� ������ getBoard(dto) �޼ҵ� ȣ�� 
			BoardDTO dto = new BoardDTO(); 
			BoardDAO dao = new BoardDAO(); 
			
			//Ŭ���̾�Ʈ���� ���� ���� dto�� setter ���� 
			dto.setSeq(Integer.parseInt(seq)); 
			
			//������ �޾ƿ´�. 
			BoardDTO board = dao.getBoard(dto); 
			
			//DB�� ���� ����� DTO (board) �� session ������ �Ҵ��ؼ� �� �������� ����
			HttpSession session = request.getSession(); 
			
			session.setAttribute("board", board); 
			
			//3. �� �������� ���� 
			response.sendRedirect("getBoard.jsp"); 
			
			
		}else if (path.equals("/logout.do")) {
			
			System.out.println("����� �α� �ƿ� ó��");
		}
		
		
	}
	
	

}

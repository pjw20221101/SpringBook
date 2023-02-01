package com.spring.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.spring.common.JDBCUtil;

@Repository("userDAO")	//DAO �� ��ü�� �ڵ����� Spring Framework�� ���� : Bean ���� 
public class UserDAO  {
	
	//JDBC ���� ���� ���� (Connection, PreparedStatement(Statement), ResultSet)
	private Connection conn = null; 
	private PreparedStatement pstmt = null; 
	private ResultSet rs = null; 
	
	// SQL ������ ���� ����� ���� :  (insert, update, delete, getUserList : ���� )  
	private final String USER_GET = "select * from users where id= ? and password = ?"; 

	//ȸ�� ������ ������ ���� �޼ҵ� : getUser(dto); 

	public UserDTO getUser(UserDTO dto) {
		//��ü ���� : DB���� select �� ���ڵ带 user �� ��Ƽ� ���� 
		UserDTO user = null; 
		
	//	System.out.println("DAO - " + dto.getId());
	//	System.out.println("DAO - " + dto.getPassword() );
		
		try {
			System.out.println("==> JDBC�� getUser() ����");
			conn = JDBCUtil.getConnection(); 
			pstmt = conn.prepareStatement(USER_GET); 
			
			//pstmt �� �Ҵ�� ������ ? , ?  �� �������� �Ҵ��� ���� : dto�� ���������� �Ҵ�. 
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			
			rs = pstmt.executeQuery();    //select ���̹Ƿ� executeQuery()�� ������ rs �� ����
			
			//rs�� ��� ���� �����ͼ� DTO (user) �� ������ ���� ������ 
			
			
			//DB�� ID�� Pass�� ��� ��ġ �� ��� if ���� �۵��� 
			if (rs.next()){		//���ڵ��� ���� �����Ҷ� Ŀ���� �ش� ���ڵ�� �̵� 
				
				user = new UserDTO(); 
				
				
				System.out.println("DB���� ���� �� select �Ǿ����ϴ�.  " );
				
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				
				System.out.println("JDBC�� DB�� �� �����ؼ� DTO�� �� ����");
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();  //������ �Ϸ��Ŀ��� �ּ� ó�� 
			System.out.println("JDBC�� ���� ������ �÷��߻� ");
			
		}finally {
			//��� ����� ��ü�� ���� : conn, pstmt, rs 
			JDBCUtil.close(rs, pstmt, conn);
		}
			
		return user; 
		
	}
	
	
}

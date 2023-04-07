package shoppingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import board.vo.BoardVO;

public class SDao {

	private DataSource dataSource;

	public SDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoardVO contentView(String strCustno) {
		System.out.println("회원번호" + strCustno);
		BoardVO board = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select * from member_tbl_02 where custno = ?";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, strCustno);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String custno = resultSet.getString("custno");

				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");

				String joindate = resultSet.getString("joindate");

				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");
				

				board = new BoardVO(custno, custname, phone, address, joindate, grade, city);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null)
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return board;
	}

	public List<BoardVO> list() {
		List<BoardVO> boards = new ArrayList<BoardVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select * from member_tbl_02 order by custno";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String custno = resultSet.getString("custno");

				String custname = resultSet.getString("custname");
				String phone = resultSet.getString("phone");
				String address = resultSet.getString("address");

				String joindate = resultSet.getString("joindate");

				String grade = resultSet.getString("grade");
				String city = resultSet.getString("city");
				

				BoardVO vo = new BoardVO(custno, custname, phone, address, joindate, grade, city);
				System.out.println(vo.getCustno());
				System.out.println(vo.getCustname());
				System.out.println(vo.getCity());
				
				boards.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (resultSet != null) 
					resultSet.close();

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return boards;

	}

	
	
	
	public int write (String custno, String custname, String phone, String address, String joindate, String grade,String city ) {
		
		System.out.println("write() ..");
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "insert into member_tbl_02 (custno, custname, phone, address, joindate, grade, city) ";
			query += "values (CUSTNO_SEQ.nextval, ?, ?, ?, sysdate, ? ,?)";


			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);


			preparedStatement.setString(1, custname);   
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			//preparedStatement.setString(4, joindate);
			preparedStatement.setString(4, grade);
			preparedStatement.setString(5, city);
			

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;
	} 

	public int modify(String custno, String custname, String phone, String address, String joindate, String grade,String city) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rn = 0;

		try {
			String query = "update member_tbl_02 set  custname = ?,  phone = ?, address = ?,grade = ?, city = ? where custno = ? ";
					

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, custname);
			preparedStatement.setString(2, phone);
			preparedStatement.setString(3, address);
			preparedStatement.setString(4, grade);
			preparedStatement.setString(5, city);
			preparedStatement.setString(6, custno);

			rn = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				if (preparedStatement != null)
					preparedStatement.close();

				if (connection != null)
					connection.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}

		return rn;
	}
	
}
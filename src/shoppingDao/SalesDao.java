package shoppingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import board.vo.SalesBoardVO;

public class SalesDao {

	private DataSource dataSource;

	public SalesDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public List<SalesBoardVO> list() {
		List<SalesBoardVO> sboards = new ArrayList<SalesBoardVO>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String query = "select m.custno, m.custname, m.grade, sum(amount *pcost) as total from member_tbl_02 m inner join money_tbl_02 o ";
				   query += "on m.custno = o.custno group by m.custno, m.custname, m.grade order by custno";

			connection = dataSource.getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				String custno = resultSet.getString("custno");
				String custname = resultSet.getString("custname");
				String grade = resultSet.getString("grade");
				String total = resultSet.getString("total");
				

				SalesBoardVO vo1 = new SalesBoardVO(custno, custname, grade, total);
				sboards.add(vo1);
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

		return sboards;

	}

}
	
	
	
	
	
	
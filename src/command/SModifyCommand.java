package command;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;
import shoppingDao.SDao;


public class SModifyCommand implements SCommand {

	@Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("BModifyCommand()..");
		
	 String custno = request.getParameter("custno");
     String custname = request.getParameter("custname");
     String phone = request.getParameter("phone");
     String address = request.getParameter("address");
     String joindate = request.getParameter("joindate");
     String grade = request.getParameter("grade");
     String city = request.getParameter("city");
     

      SDao dao = new SDao();        
      dao.modify(custno, custname, phone, address, joindate, grade, city);  
		
		
	   }
	   
	}
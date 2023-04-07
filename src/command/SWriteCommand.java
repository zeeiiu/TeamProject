package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shoppingDao.SDao;


public class SWriteCommand implements SCommand {

	@Override
	   public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		
        String custno = request.getParameter("custno");
        String custname = request.getParameter("custname");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String joindate = request.getParameter("joindate");
        String grade = request.getParameter("grade");
        String city = request.getParameter("city");
   
        
   
         SDao dao = new SDao();          
        dao.write(custno, custname, phone, address, joindate, grade, city);
		
		
	   }
	   
	}
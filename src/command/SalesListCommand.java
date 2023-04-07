package command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import board.vo.SalesBoardVO;

import shoppingDao.SalesDao;


public class SalesListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		SalesDao dao1 = new SalesDao(); 

		List<SalesBoardVO> vos1 = dao1.list(); // DAO 안의 list()를 호출하여 BoardVO의 List 객체 생성

		request.setAttribute("sboards", vos1); // 요청하여 갖고 오기
	}

}

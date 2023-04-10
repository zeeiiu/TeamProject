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

		List<SalesBoardVO> vos1 = dao1.list(); // DAO ���� list()�� ȣ���Ͽ� BoardVO�� List ��ü ����

		request.setAttribute("sboards", vos1); // ��û�Ͽ� ���� ����
	}

}

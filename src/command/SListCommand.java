package command;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;
import shoppingDao.SDao;


public class SListCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		SDao dao = new SDao(); 

		List<BoardVO> vos = dao.list(); // DAO ���� list()�� ȣ���Ͽ� BoardVO�� List ��ü ����
		System.out.println("List<BoardVO> �Ѱ���" + vos.size());
		request.setAttribute("boards", vos); // ��û�Ͽ� ���� ����
	}

}

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

		List<BoardVO> vos = dao.list(); // DAO 안의 list()를 호출하여 BoardVO의 List 객체 생성
		System.out.println("List<BoardVO> 총개수" + vos.size());
		request.setAttribute("boards", vos); // 요청하여 갖고 오기
	}

}

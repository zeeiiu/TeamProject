package command;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;
import shoppingDao.SDao;


public class SContentCommand implements SCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String bid = request.getParameter("custno");
		System.out.println("bid ¹øÈ£"+ bid);
		
		SDao vo = new SDao();
		BoardVO dto = vo.contentView(bid);
		
		System.out.println(dto.getAddress());
		System.out.println(dto.getCity());
		System.out.println(dto.getAddress());
		
		request.setAttribute("content_view", dto);
		
		
		
	}
}

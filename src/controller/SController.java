package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.SCommand;
import command.SContentCommand;
import command.SListCommand;
import command.SModifyCommand;
import command.SWriteCommand;
import command.SalesListCommand;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.do")
public class SController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		actionDo(request, response);
 
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // �� Ŭ���� �ȿ����� ����� �� ���� = private

		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		SCommand command = null;

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String com = uri.substring(contextPath.length());

		System.out.println("uri :" + uri);
		System.out.println("contextPath :" + contextPath);
		System.out.println("com :" + com);

		// http://localhost:8282/suvrvlet_ajw_board/content_view.do?bid=1

		if (com.equals("/list.do")) { // list.do�� ġ�� ������ �Ǹ� �ش� request ��ü �ȿ� �Խ��� �۵��� ������ ��.
			command = new SListCommand(); // ������ ����
			command.execute(request, response); // request�ȿ��ٰ� �Խù� ���� �������
			viewPage = "list.jsp";
			System.out.println("����Ʈ do ��");

		} else if (com.equals("/content_view.do")) {// http://localhost:8282/suvrvlet_ajw_board/content_view.do?bid=1}

			command = new SContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";

		} else if (com.equals("/modify.do")) {
			
			System.out.println("/modify.do");
			
			command = new SModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		} else if (com.equals("/write_view.do")) {
			
			System.out.println("/write_view.do.."); // if�� Ÿ���� Ȯ��
			viewPage = "write_view.jsp";
		
		}else if (com.equals("/write.do")) {
			
			System.out.println("/write.do.."); // if�� Ÿ���� Ȯ��
			
			command = new SWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
			
		} else if(com.equals("/salesList.do")) { 
			
			command = new SalesListCommand(); // ������ ����
			command.execute(request, response); // request�ȿ��ٰ� �Խù� ���� �������
			viewPage = "salesList.jsp";	

		}
		System.out.println(command);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // list.jsp�� viewPage�ȿ� ��.
		dispatcher.forward(request, response); // request�ȿ� �Խñ��� ����ְ�.. �� �������� forward���Ѽ� view�� �ѷ���.
	}
}

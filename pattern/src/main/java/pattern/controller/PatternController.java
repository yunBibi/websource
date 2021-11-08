package pattern.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.action.Action;
import pattern.action.ActionForward;


@WebServlet("*.do")
public class PatternController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청에 대한 한글 처리
		request.setCharacterEncoding("utf-8");
		
		// 요청이 어디에서 왔는지 파악
		// ex. /index.do 만 들어오게 하는 
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestUri.substring(contextPath.length());
		
		// singleton 패턴이 외부에서 사용되는 방법
		// 요청에 따라서 해당 Action을 생성
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.action(cmd);
		
		
		ActionForward actionForward = null;
		
		try {
			// 생성된 Action에게 일을 시킴 => 결과를 ActionForward 객체로 넘겨 받음
			actionForward = action.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 넘겨받은 ActionForward가 가지고 있는 값에 따라서 페이지 이동
		if(actionForward.isRedirect()) {
			response.sendRedirect(actionForward.getPath());
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(actionForward.getPath());
			rd.forward(request,response);
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

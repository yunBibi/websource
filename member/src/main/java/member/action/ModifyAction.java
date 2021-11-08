package member.action;

import javax.servlet.http.HttpServletRequest;

public class ModifyAction implements Action {
	private String path;
	
	public ActionForward execute(HttpServletRequest request) throws Exception {
		
		// userid 가져오기 - 세션
		HttpSession session = request.getSessoin();
		MemberDTO loginDto = session.getAttribute("loginDto");
		String userid = loginDto.getUserid();
		
		// modifyForm.jsp 에서 사용자 입력값 가져오기
		String current_password=request.getParameter("current_password");
		String new_password = request.getParameter("new_password");
		String confirm_password = request.getParameter("confirm_password");
		UpdateDTO updateDto = new UpdateDTO(userid, current_password, new_password, confirm_password);
		
		if(updateDto.passswordEqualTo(new_password)) {
			// db작업
			ModifyService service = new ModifyService();
			boolean updateFlag = service.modify(updateDto);
			
			// 성공 시 commit, 현재 세션 해제, 로그인 페이지로 이동
			if(updateFlag) {
				session.invalidate();
			
			}else {
				// 실패 : rollback, 비밀번호 변경 페이지로 이동
				path = "/view/modifyForm.jsp";
			}
			
		}else {
			// 비밀번호 변경 페이지로 이동
			path = "/view/modifyForm.jsp";
			
		}

		return new ActionForward(path, true);
	}
}

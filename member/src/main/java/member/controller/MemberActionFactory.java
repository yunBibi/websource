package member.controller;

import member.action.Action;

import member.action.LoginAction;

public class MemberActionFactory {
	// 싱글톤singleton 객체 생성
	private static MemberActionFactory maf;
	private Action action;
	
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(maf == null) {
			maf = new MemberActionFactory();		
		}
		return maf;
		
	}
	public Action action(String cmd) {
		// action이 성공한 후 가야할 페이지
		if(cmd.equals("login.do")) {
			action = new LoginAction("/view/loginForm.jsp");
			
		} else if{
			
		}
		return action;
	}
}

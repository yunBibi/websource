<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 특정 세션 제거
	session.removeAttribute("name");
	// 페이지 이동
	response.sendRedirect("sessionTest1.jsp");

%>
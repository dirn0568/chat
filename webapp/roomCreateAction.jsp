<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="room.roomDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="room" class="room.room" scope="page" /> 
<jsp:setProperty name="room" property="roomNAME" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (room.getRoomNAME() == null) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('입력이 안된 부분이 있습니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else {
			roomDAO room_cr = new roomDAO();
			String result = room_cr.roomCreate(room.getRoomNAME());
			if ( result == "1" ) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('room 생성')");
				script.println("</script>");
			}
		}
	%>
</body>
</html>
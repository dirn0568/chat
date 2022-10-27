<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="room.roomDAO" %>
<%@ page import="room.room" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		try{
			roomDAO roomDATA = new roomDAO();
			ArrayList<room> roomLIST = roomDATA.room_list();
			for(int i = 0; i <= roomLIST.size(); i++) {
	%>
			<div align="right" style="background:#FFE400;">
				<a href="broadcast.jsp?roomNAME=<%= roomLIST.get(i).getRoomNAME() %>">
					<tr>
						<td><%= roomLIST.get(i).getRoomID() %></td>
						<td><%= roomLIST.get(i).getRoomNAME() %></td>
						<td><%= roomLIST.get(i).getRoomDATE().substring(0, 11) + roomLIST.get(i).getRoomDATE().substring(11, 13) + "시" + roomLIST.get(i).getRoomDATE().substring(14, 16) + "분" %></td>
					</tr>
				</a>
			</div>
			<p></p>
	<%
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	%>
	방찾기
	<a href="roomCreate.jsp">방만들기</a>
</body>
</html>
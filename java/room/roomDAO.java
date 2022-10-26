package room;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class roomDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public roomDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/project23";
			String dbID = "root";
			String dbPassword = "root";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; //데이터베이스 오류
	}
	
	public ArrayList<room> room_list() {
		ArrayList<room> temp_list = new ArrayList<room>();
		String SQL = "select * from room";
		try {
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				room data = new room();
				data.setRoomID(rs.getString(1));
				data.setRoomNAME(rs.getString(2));
				data.setRoomDATE(rs.getString(3));
				temp_list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp_list;
	}
	
	public String roomCreate(String roomName) {
		String SQL = "INSERT INTO room VALUES (?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, 1);
			pstmt.setString(2, roomName);
			pstmt.setString(3, getDate());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "1";
	}
}

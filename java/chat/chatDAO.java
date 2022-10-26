package chat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class chatDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public chatDAO() {
		try {
			System.out.println("조ㅓㄴ나 색시했어");
			String dbURL = "jdbc:mysql://localhost:3306/project23";
			String dbID = "root";
			String dbPassword = "root";
			System.out.println("sdfsadf");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("sdfsadf");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
			System.out.println("sdfsadf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int chatCreate(String message) {
		String SQL = "INSERT INTO cha VALUES(?)";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, message);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
}

package kr.or.dgit.bigdata.coffee.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoffeeJdbcUtil {
	public static void close(Statement stmt){
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	public static void close(ResultSet rs){
		if (rs !=null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
}

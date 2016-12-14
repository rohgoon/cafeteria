package kr.or.dgit.bigdata.coffee.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;

public class CoffeeDbc {
	private static CoffeeDbc instance =new CoffeeDbc();
	private static Connection con;
	
	public CoffeeDbc() {
		try {
			con = DriverManager.getConnection(CoffeeConfig.URL, CoffeeConfig.USER, CoffeeConfig.PWD);
			
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection(){
		if(instance == null){
			new CoffeeDbc();
		}
		
		return CoffeeDbc.con;
	}
	public static void closeConnection(){
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
}

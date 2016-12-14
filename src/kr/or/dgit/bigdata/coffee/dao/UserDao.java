package kr.or.dgit.bigdata.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeJdbcUtil;

public class UserDao implements CoffeeInterDao<UserDao> {
	private PreparedStatement pstmt;
	private static UserDao instance = new UserDao();
	
	public UserDao() {
		
	}
	
	public static UserDao getInstance(){
		return instance;
	}
	
	public void initUser(){
		createItem();
		
		
	}
	

	@Override
	public void createItem() {
		String sql = "grant select, insert,update,delete on "
				+ CoffeeConfig.DB_NAME+".* to ? identified by ?";
		PreparedStatement pstmt = null;
		Connection con = CoffeeDbc.getConnection();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  CoffeeConfig.PJT_USER);
			pstmt.setString(2,  CoffeeConfig.PJT_PASSED);
			pstmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
		
	}

	
	// ?ъ슜?덊븿
	@Override
	public void dropItem() {
		// TODO Auto-generated method stub
		
	}

}

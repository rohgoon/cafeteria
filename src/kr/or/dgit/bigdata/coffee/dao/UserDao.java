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

	public static UserDao getInstance() {
		return instance;
	}

	public void initUser() {
		createItem();
		grantUser();
	}

	private void grantUser() {
		String sql = "grant select, insert, update, delete on " + CoffeeConfig.DB_NAME + ".* to ?";
		PreparedStatement pstmt = null;
		
			Connection con = CoffeeDbc.getConnection();
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, CoffeeConfig.PJT_USER);
				pstmt.executeUpdate();
				System.out.printf("%s가 권한 획득 %n",CoffeeConfig.PJT_USER);
			} catch (SQLException e) {
				System.out.printf("%s가 권한 획득 실패 %n",CoffeeConfig.PJT_USER);
				e.printStackTrace();
			} finally {
				CoffeeJdbcUtil.close(pstmt);
			}
			
			
		
	}

	@Override
	public void createItem() {
		String sql = "create user ? identified by ?";
		PreparedStatement pstmt = null;
		try {
			Connection con = CoffeeDbc.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, CoffeeConfig.PJT_USER);
			pstmt.setString(2, CoffeeConfig.PJT_PASSWD);
			pstmt.execute();
			System.out.printf("Create User(%s) Success! %n", CoffeeConfig.PJT_USER);
		} catch (SQLException e) {
			if (e.getErrorCode()==1396){
				System.err.printf("User(%s) exists!%n", CoffeeConfig.PJT_USER);
				dropItem();
				createItem();
			}
		} finally {
			CoffeeJdbcUtil.close(pstmt);
		}

	}

	
	@Override
	public void dropItem() {
		

	}

}

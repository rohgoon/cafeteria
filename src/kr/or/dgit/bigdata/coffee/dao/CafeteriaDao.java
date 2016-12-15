package kr.or.dgit.bigdata.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.dto.PdtCode;
import kr.or.dgit.bigdata.coffee.dto.PdtSale;
import kr.or.dgit.bigdata.coffee.dto.ViewTable;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeJdbcUtil;

public class CafeteriaDao implements CoffeeInterDao<CafeteriaDao>{
	private PreparedStatement pstmt;
	private static CafeteriaDao instance = new CafeteriaDao();
	
	public CafeteriaDao() {
		
	}
	
	public static CafeteriaDao getInstance(){
		return instance;
	}

	@Override
	public void createItem() {
		Connection con = CoffeeDbc.getConnection();
		try {
			pstmt = con.prepareStatement("create database "+CoffeeConfig.DB_NAME);
			pstmt.execute();
			System.out.println("데이터베이스 생성 성공");
		} catch (SQLException e) {
			if (e.getErrorCode()==1007) {
				System.out.println("데이터베이스가 이미 존재합니다.");
				dropItem();
				createItem();
			}
			
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
		
	}

	@Override
	public void dropItem() {
		Connection con = CoffeeDbc.getConnection();
		try {
			pstmt = con.prepareStatement("drop database if exists " +CoffeeConfig.DB_NAME);
			pstmt.execute();
			System.out.println("데이터베이스 삭제 성공");			
		} catch (SQLException e) {
			System.out.println("데이터베이스 생성 실패");
		}finally {
			CoffeeJdbcUtil.close(pstmt);
			
		}
	}
	
	public void selectUseDatabase(){
		Connection con = CoffeeDbc.getConnection();
		try {
			pstmt = con.prepareStatement("use " +CoffeeConfig.DB_NAME);
			pstmt.execute();
			System.out.printf("%s 데이터베이스를 사용 성공.",CoffeeConfig.DB_NAME);
		} catch (SQLException e) {
			System.out.printf("%s 데이터베이스를 사용 실패.",CoffeeConfig.DB_NAME);
			e.printStackTrace();
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
	}
	
	public void setForeignKeyCheck(int isCheck){
		Connection con = CoffeeDbc.getConnection();
		try {
			pstmt = con.prepareStatement("set foreign_key_checks =?");
			pstmt.setInt(1, isCheck);
			pstmt.execute();
			System.out.println("set foreign_key_checks 성공");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
	}
	
	public int insertTable(PdtCode c) {
		String sql = "insert into cafeteria.pdtcode values(?,?)";
		Connection con = CoffeeDbc.getConnection();
		int res = -1;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, c.getCfCode());
			pstmt.setString(2, c.getCfName());
			System.out.println(pstmt);

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			if (e.getErrorCode() == 1062) {
				System.out.println("중복입니다.");
			}
			e.printStackTrace();

		} finally {
			CoffeeJdbcUtil.close(pstmt);
		}

		return res;
	}
	
	public int insertTable(PdtSale s) {
		String sql = "insert into cafeteria.pdtsale values(?,?,?,?)";
		Connection con = CoffeeDbc.getConnection();
		int res = -1;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getCfCode());
			pstmt.setInt(2, s.getCfOne());
			pstmt.setInt(3, s.getCfSell());
			pstmt.setInt(4, s.getCfMargin());
			System.out.println(pstmt);

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			if (e.getErrorCode() == 1062) {
				System.out.println("중복입니다.");
			}
			e.printStackTrace();

		} finally {
			CoffeeJdbcUtil.close(pstmt);
		}

		return res;
	}
	
}



















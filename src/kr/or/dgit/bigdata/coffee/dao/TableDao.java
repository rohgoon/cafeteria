package kr.or.dgit.bigdata.coffee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeJdbcUtil;

public class TableDao{
	private PreparedStatement pstmt;
	private static TableDao instance = new TableDao();
	
	public TableDao() {
		
	}
	
	public static TableDao getInstance(){
		return instance;
	}
	
	

	public void createItem(String sql) {
		Connection con = CoffeeDbc.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.println("테이블 생성 성공");
		} catch (SQLException e) {
			if (e.getErrorCode()==1007) {
				System.out.println("테이블 생성 실패.");
				e.printStackTrace();
			}
			
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
		
	}
	public void createViewTable(){
		Connection con = CoffeeDbc.getConnection();
		String sql ="create view_v_output as "
				+ "select c.cfCode, cfName , cfOne, cfSell, cfMargin, cfOne*cfSell as salePrise, "
				+ "round(cfOne*cfSell/11, 0) as addTax, cfOne*cfSell-round(cfOne*cfSell/11,0) as supplyPrice, "
				+ "round(((cfOne*cfSell-round(cfOne*cfSell/11,0))*(cfMargin/100)),0) as marginPrice "
				+ "from pdtcode c , pdtsale s "
				+ "where c.cfCode = s.cfCode "
				+ "order by salePrise desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.println("뷰테이블 생성 성공");
		} catch (SQLException e) {
			System.out.println("뷰테이블 생성 실패");
			e.printStackTrace();
		}finally {
			CoffeeJdbcUtil.close(pstmt);
		}
				
				
		
	}
	
}

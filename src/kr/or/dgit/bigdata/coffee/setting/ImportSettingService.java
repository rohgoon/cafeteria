package kr.or.dgit.bigdata.coffee.setting;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.dao.CafeteriaDao;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeJdbcUtil;

public class ImportSettingService extends ServiceSetting {

	@Override
	public void initSetting() {
		CafeteriaDao dao = CafeteriaDao.getInstance();
		dao.selectUseDatabase();
		dao.setForeignKeyCheck(0);
		for (String t : CoffeeConfig.TABLE_NAME) {
			executeImportDate(getFilePath(t, true), t);
		}
		dao.setForeignKeyCheck(1);

	}

	private void executeImportDate(String tablePath, String tableName) {
		String sql = String.format("LOAD DATA LOCAL INFILE '%s' INTO TABLE %s character set 'UTF8' fields TERMINATED by ','",
				tablePath, tableName);
		Statement stmt = null;
		try {
			Connection con = CoffeeDbc.getConnection();
			stmt = con.createStatement();
			stmt.execute(sql);
			System.out.printf("Import Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			e.printStackTrace();
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} finally {
			CoffeeJdbcUtil.close(stmt);
		}

	}

}

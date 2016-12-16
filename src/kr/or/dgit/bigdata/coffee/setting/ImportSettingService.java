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
			executeImporData(getFilePath(t, true), t);
		}
		dao.setForeignKeyCheck(1);

	}

	private void executeImporData(Object filePath, String t) {
		String sql = String.format("load data infile '%s' into table %s character set 'utf8 fields terminated by ','",
				filePath, t);
		Statement stmt = null;
		Connection con = CoffeeDbc.getConnection();
		try {
			stmt = con.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062) {
				System.err.println("중복데이터 존재");
			}
		} finally {
			CoffeeJdbcUtil.close(stmt);
		}

	}

}

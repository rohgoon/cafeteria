package kr.or.dgit.bigdata.coffee.setting;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.dao.CafeteriaDao;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.jdbc.CoffeeJdbcUtil;

public class ExportSettingService extends ServiceSetting {

	@Override
	public void initSetting() {
		CafeteriaDao dao = CafeteriaDao.getInstance();
		dao.selectUseDatabase();

		checkBackupDir();

		for (String tableName : CoffeeConfig.TABLE_NAME) {
			executeExportData(getFilePath(tableName, false), tableName); // 확인요망
		}
		copyFile();
	}

	private void copyFile() {
		File srcDir = new File(CoffeeConfig.MYSQL_EXPORT_PATH);
		File destDir = null;
		for (File file : srcDir.listFiles()) {
			destDir = new File(CoffeeConfig.IMPORT_DIR + file.getName());
			file.renameTo(destDir);
			file.delete(); // MYSQL_EXPORT_PATH의 파일을 지움
		}

	}

	private void executeExportData(Object filePath, String tableName) {
		String sql = String.format("select * into outfile '%s' " 
					+ "character set 'UTF8' " 
					+ "fields terminated by ',' "
					+ "lines terminated by '\n' from %s", filePath, tableName);
		Statement stmt = null;
		System.out.println(" 확인 : "+sql);
		Connection con = CoffeeDbc.getConnection();
		try {
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			
			System.out.printf("Export Table(%s) %d Rows Success! %n",tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
			//e.printStackTrace();
		} finally {
			CoffeeJdbcUtil.close(stmt);
		}

	}

	private void checkBackupDir() {
		File backupDir = new File(CoffeeConfig.EXPORT_DIR);
		if (backupDir.exists()) {
			for (File file : backupDir.listFiles()) {
				file.delete();
				System.out.println("백업 파일 삭제 완료");
			}

		} else {
			backupDir.mkdir();
			System.out.println("백업 파일 생성 완료");

		}

	}

}

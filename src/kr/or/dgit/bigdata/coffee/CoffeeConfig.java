package kr.or.dgit.bigdata.coffee;

public class CoffeeConfig {
	public static final String USER = "root";
	public static final String PWD = "rootroot";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "cafeteria";
	public static final String PJT_USER = "user_cafeteria";
	public static final String PJT_PASSED = "rootroot";
	public static final String[] TABLE_NAME = { "pdtcode", "pdtsale" };
	public static final String EXPORT_DIR = System.getProperty("user.dir") + "\\BackupFiles\\";
	public static final String IMPORT_DIR = System.getProperty("user.dir") + "\\DataFiles\\";
	public static final String MYSQL_EXPORT_PATH = "C:\\ProgramData\\MySQL\\MySQL Server 5.6\\Uploads\\";

}

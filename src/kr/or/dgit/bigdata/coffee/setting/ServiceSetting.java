package kr.or.dgit.bigdata.coffee.setting;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;

public abstract class ServiceSetting {
	protected static String gerFilePath(String tableName, boolean isImport){
		StringBuilder sb = new StringBuilder();
		sb.append(isImport ? CoffeeConfig.IMPORT_DIR : CoffeeConfig.MYSQL_EXPORT_PATH).append(tableName).append(".txt");
		return sb.toString().replace("\\", "/");
		
		
	}
	public abstract void initSetting();
}

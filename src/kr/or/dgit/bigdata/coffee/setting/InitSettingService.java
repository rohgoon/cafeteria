package kr.or.dgit.bigdata.coffee.setting;

import java.util.HashMap;
import java.util.Map;

import kr.or.dgit.bigdata.coffee.CoffeeConfig;
import kr.or.dgit.bigdata.coffee.dao.CafeteriaDao;
import kr.or.dgit.bigdata.coffee.dao.TableDao;
import kr.or.dgit.bigdata.coffee.dao.UserDao;

public class InitSettingService extends ServiceSetting {
	private Map<String, String> TABLE_SQL = new HashMap<>();
	
	@Override
	public void initSetting() {
		creatSql();
		creatDatabase();
		createTable();
		creatUser();

	}

	private void creatUser() {
		UserDao.getInstance().initUser();
		
	}

	private void createTable() {
		TableDao dao = TableDao.getInstance();
		for (int i = 0; i < CoffeeConfig.TABLE_NAME.length; i++) {
			dao.createItem(TABLE_SQL.get(CoffeeConfig.TABLE_NAME[i]));
		}
		dao.createViewTable();
	}

	private void creatDatabase() {
		CafeteriaDao dao =  CafeteriaDao.getInstance();
		dao.createItem();
		dao.selectUseDatabase();
		
		
	}

	private void creatSql() {
		TABLE_SQL.put("pdtcode", "create table pdtcode (cfcode varchar(10),cfname varchar(20), primary key(cfcode))");
		TABLE_SQL.put("pdtsale", "create table pdtsale (cfcode varchar(10),cfOne int(11), cfSell int(11), cfmargin int(11), "
				+ "primary key (cfcode), foreign key (cfcode) references pdtcode (cfcode))");
		
	}
	
	
}




















package kr.or.dgit.bigdata.coffee.ui.list;

import java.util.List;

import kr.or.dgit.bigdata.coffee.dao.TableDao;
import kr.or.dgit.bigdata.coffee.dto.ViewTable;

public class CoffeeList1 extends CoffeeList {

	public CoffeeList1(String str) {

		super(str);
		
	}
	
	String[][] getRowData() {
		List<ViewTable> list = TableDao.getInstance().selectItemByAll1();
		System.out.println("[getRowData]size:" + list.size());

		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray(); // 행 순서 변경시 이걸 변경2
		}

		return rowDatas;
	}
	

}

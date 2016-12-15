package kr.or.dgit.bigdata.coffee.ui.list;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.bigdata.coffee.dao.TableDao;
import kr.or.dgit.bigdata.coffee.dto.ViewTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CoffeeList2 extends JPanel {
	private JTable table_2;

	/**
	 * Create the panel.
	 */
	public CoffeeList2() {
		setBorder(new EmptyBorder(10, 0, 10, 0));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("마 진 액 순 위");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(lblTitle, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		
		table_2 = new JTable();
		/*table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC21C\uC704", "\uC81C\uD488\uCF54\uB4DC", "\uC81C\uD488\uBA85", "\uC81C\uD488\uB2E8\uAC00", "\uD310\uB9E4\uC218\uB7C9", "\uACF5\uAE09\uAC00\uC561", "\uBD80\uAC00\uC138\uC561", "\uD310\uB9E4\uAE08\uC561", "\uB9C8\uC9C4\uC728", "\uB9C8\uC9C4\uC561"
			}
		));*//*
		table_1.getColumnModel().getColumn(0).setMinWidth(75);
		table_1.getColumnModel().getColumn(1).setMinWidth(75);
		table_1.getColumnModel().getColumn(2).setMinWidth(75);
		table_1.getColumnModel().getColumn(3).setMinWidth(75);
		table_1.getColumnModel().getColumn(4).setMinWidth(75);
		table_1.getColumnModel().getColumn(5).setMinWidth(75);
		table_1.getColumnModel().getColumn(6).setMinWidth(75);
		table_1.getColumnModel().getColumn(7).setMinWidth(75);
		table_1.getColumnModel().getColumn(8).setMinWidth(75);
		table_1.getColumnModel().getColumn(9).setMinWidth(75);*/
		scrollPane.setViewportView(table_2);
		reloadData();

	}

	public void reloadData() {///
		DefaultTableModel model = new DefaultTableModel(getRowData(), getColumnData());
		table_2.setModel(model);
		tableSetAlignWith();
		
		
	}
	private String[] getColumnData() {
		
		return new String[] {"순위","코드","제품명","단가","판매수량","마진율","판매금액","부가세액","공급가액","마진액"};
	} // 행 순서 변경시 이것 변경1


	private String[][] getRowData() {
		List<ViewTable> list = TableDao.getInstance().selectItemByAll2();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray(); // 행 순서 변경시 이걸 변경2
		}
		
		
		return rowDatas;
	}


	protected void tableSetWidth(int...width){//
		TableColumnModel model = table_2.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}
	}
	protected void tableSetAlignWith() {//
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8 ,9);
		tableSetWidth(60,100, 200, 200, 200, 200, 200, 200, 200, 200);
		// 순위, 코드, 제품명, 단가, 판매수량, 마진율, 판매금액, 부가세액, 공급가액, 마진액
	}
	protected void tableCellAlignment(int align, int...idx){//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);
		TableColumnModel model = table_2.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}
	
}

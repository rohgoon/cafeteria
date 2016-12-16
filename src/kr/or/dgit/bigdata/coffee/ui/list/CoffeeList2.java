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
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CoffeeList2 extends JPanel {
	private JTable table_2;
	private JLabel lblTotalSale;
	private JLabel lblTotalTax;
	private JLabel lblTotalSupply;
	private JLabel lblTotalMp;

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

		scrollPane.setViewportView(table_2);

		JPanel pTotal = new JPanel();
		pTotal.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(pTotal, BorderLayout.SOUTH);
		pTotal.setLayout(new GridLayout(0, 10, 0, 0));

		JLabel lblTotal = new JLabel("합계 : ");
		pTotal.add(lblTotal);

		JLabel label_9 = new JLabel("");
		pTotal.add(label_9);

		JLabel label_8 = new JLabel("");
		pTotal.add(label_8);

		JLabel label_7 = new JLabel("");
		pTotal.add(label_7);

		JLabel label_6 = new JLabel("");
		pTotal.add(label_6);

		JLabel label_5 = new JLabel("");
		pTotal.add(label_5);

		lblTotalSale = new JLabel("");
		lblTotalSale.setHorizontalAlignment(SwingConstants.CENTER);
		pTotal.add(lblTotalSale);

		lblTotalTax = new JLabel("");
		lblTotalTax.setHorizontalAlignment(SwingConstants.CENTER);
		pTotal.add(lblTotalTax);

		lblTotalSupply = new JLabel("");
		lblTotalSupply.setHorizontalAlignment(SwingConstants.RIGHT);
		pTotal.add(lblTotalSupply);

		lblTotalMp = new JLabel("");
		lblTotalMp.setHorizontalAlignment(SwingConstants.RIGHT);
		pTotal.add(lblTotalMp);

		reloadData();

	}

	public void reloadData() {///
		DefaultTableModel model = new DefaultTableModel(getRowData(), getColumnData());
		table_2.setModel(model);

		tableSetAlignWith();

		//
		List<ViewTable> list = TableDao.getInstance().selectItemByAll1();
		String[][] sumDatas = new String[list.size()][];

		int sumSale = 0;
		int sumTax = 0;
		int sumSupply = 0;
		int sumMp = 0;

		for (int i = 0; i < list.size(); i++) {
			sumDatas[i] = list.get(i).forSumArray();
		}
		for (int i = 0; i < list.size(); i++) {
			sumSale += Integer.parseInt(sumDatas[i][0]);
			sumTax += Integer.parseInt(sumDatas[i][1]);
			sumSupply += Integer.parseInt(sumDatas[i][2]);
			sumMp += Integer.parseInt(sumDatas[i][3]);

		}

		lblTotalSale.setText(sumSale + "");
		lblTotalTax.setText(sumTax + "");
		lblTotalSupply.setText(sumSupply + "");
		lblTotalMp.setText(sumMp + "");

	}

	private String[] getColumnData() {

		return new String[] { "순위", "코드", "제품명", "단가", "판매수량", "마진율", "판매금액", "부가세액", "공급가액", "마진액" };
	} // 행 순서 변경시 이것 변경1

	private String[][] getRowData() {
		List<ViewTable> list = TableDao.getInstance().selectItemByAll2();
		String[][] rowDatas = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			rowDatas[i] = list.get(i).toArray(); // 행 순서 변경시 이걸 변경2
		}

		return rowDatas;
	}

	protected void tableSetWidth(int... width) {//
		TableColumnModel model = table_2.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			model.getColumn(i).setPreferredWidth(width[i]);
		}

	}

	protected void tableSetAlignWith() {//
		tableCellAlignment(SwingConstants.CENTER, 0, 1, 2);
		tableCellAlignment(SwingConstants.RIGHT, 3, 4, 5, 6, 7, 8, 9);
		tableSetWidth(60, 100, 200, 200, 200, 200, 200, 200, 200, 200);
		// 순위, 코드, 제품명, 단가, 판매수량, 마진율, 판매금액, 부가세액, 공급가액, 마진액
	}

	protected void tableCellAlignment(int align, int... idx) {//
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel model = table_2.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			model.getColumn(idx[i]).setCellRenderer(dtcr);
		}

	}

}

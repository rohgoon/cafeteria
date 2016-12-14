package kr.or.dgit.bigdata.coffee.ui.list;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class CoffeeList1 extends JPanel {
	private JTable table_1;

	/**
	 * Create the panel.
	 */
	public CoffeeList1() {
		setBorder(new EmptyBorder(10, 0, 10, 0));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("판 매 금 액 순 위");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		add(lblTitle, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC21C\uC704", "\uC81C\uD488\uCF54\uB4DC", "\uC81C\uD488\uBA85", "\uC81C\uD488\uB2E8\uAC00", "\uD310\uB9E4\uC218\uB7C9", "\uACF5\uAE09\uAC00\uC561", "\uBD80\uAC00\uC138\uC561", "\uD310\uB9E4\uAE08\uC561", "\uB9C8\uC9C4\uC728", "\uB9C8\uC9C4\uC561"
			}
		));
		table_1.getColumnModel().getColumn(0).setMinWidth(75);
		table_1.getColumnModel().getColumn(1).setMinWidth(75);
		table_1.getColumnModel().getColumn(2).setMinWidth(75);
		table_1.getColumnModel().getColumn(3).setMinWidth(75);
		table_1.getColumnModel().getColumn(4).setMinWidth(75);
		table_1.getColumnModel().getColumn(5).setMinWidth(75);
		table_1.getColumnModel().getColumn(6).setMinWidth(75);
		table_1.getColumnModel().getColumn(7).setMinWidth(75);
		table_1.getColumnModel().getColumn(8).setMinWidth(75);
		table_1.getColumnModel().getColumn(9).setMinWidth(75);
		scrollPane.setViewportView(table_1);

	}

}

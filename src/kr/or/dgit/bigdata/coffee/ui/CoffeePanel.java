package kr.or.dgit.bigdata.coffee.ui;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class CoffeePanel extends JPanel {
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtCfone;
	private JTextField txtSell;
	private JTextField txtMargin;

	/**
	 * Create the panel.
	 */
	public CoffeePanel() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setLayout(new GridLayout(5, 2, 10, 10));
		
		JLabel lblCode = new JLabel("제품코드");
		lblCode.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCode);
		
		txtCode = new JTextField();
		add(txtCode);
		txtCode.setColumns(10);
		
		JLabel lblName = new JLabel("제품명");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		add(txtName);
		txtName.setColumns(10);
		
		JLabel lblCfone = new JLabel("제품단가");
		lblCfone.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblCfone);
		
		txtCfone = new JTextField();
		add(txtCfone);
		txtCfone.setColumns(10);
		
		JLabel lblSell = new JLabel("판매수량");
		lblSell.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblSell);
		
		txtSell = new JTextField();
		add(txtSell);
		txtSell.setColumns(10);
		
		JLabel lblMargin = new JLabel("마진율");
		lblMargin.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblMargin);
		
		txtMargin = new JTextField();
		add(txtMargin);
		txtMargin.setColumns(10);
		
	}

	public String getTxtCode() {
		return txtCode.getText().trim();
	}

	public String getTxtName() {
		return txtName.getText().trim();
	}

	public int getTxtCfone() {
		return Integer.parseInt(txtCfone.getText().trim());
	}

	public int getTxtSell() {
		return Integer.parseInt(txtSell.getText().trim());
	}

	public int getTxtMargin() {
		return Integer.parseInt(txtMargin.getText().trim());
	}
	
}

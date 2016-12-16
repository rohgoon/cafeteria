package kr.or.dgit.bigdata.coffee.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.coffee.dao.TableDao;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

public class CoffeePanel extends JPanel implements FocusListener {
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
		txtCode.addFocusListener(this);
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
	

	public void setTxtName(String txtName) {
				
		this.txtName.setText(txtName);
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

	public void setClearTxtCode() {
		this.txtCode.setText("");
	}
	
	public void setClearTxtCfone() {
		this.txtCfone.setText("");
		this.txtSell.setText("");
		this.txtMargin.setText("");
	}


	public void setClearTxtSell() {
		this.txtSell.setText("");
	}

	public void setClearTxtMargin() {
		this.txtMargin.setText("");
	}
	
	
	
	public void focusGained(FocusEvent arg0) {
	}
	public void focusLost(FocusEvent e) {
		if (e.getSource() == txtCode) {
			focusLostTxtCode(e);
		}
	}
	protected void focusLostTxtCode(FocusEvent e) {
		String cfCode = getTxtCode();

		String[][] codeList = { { "A001", "아메리카노" }, { "A002", "카푸치노" }, { "A003", "헤이즐넛" }, { "A004", "에스프레소" },
				{ "B001", "딸기쉐이크" }, { "B002", "후르츠와인" }, { "B003", "팥빙수" }, { "B004", "아이스초코" } };
		String cfName = null;

		for (int i = 0; i < codeList.length; i++) {

			if (codeList[i][0].equals(cfCode)) {
				cfName = codeList[i][1];
				setTxtName(codeList[i][1]);
				
				break;
			}
		};
		
	}
}

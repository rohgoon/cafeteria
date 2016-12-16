package kr.or.dgit.bigdata.coffee;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.coffee.dao.CafeteriaDao;
import kr.or.dgit.bigdata.coffee.dto.PdtCode;
import kr.or.dgit.bigdata.coffee.dto.PdtSale;
import kr.or.dgit.bigdata.coffee.setting.ExportSettingService;
import kr.or.dgit.bigdata.coffee.setting.ImportSettingService;
import kr.or.dgit.bigdata.coffee.setting.InitSettingService;
import kr.or.dgit.bigdata.coffee.setting.ServiceSetting;
import kr.or.dgit.bigdata.coffee.ui.CoffeePanel;
import kr.or.dgit.bigdata.coffee.ui.list.CoffeeList1;
import kr.or.dgit.bigdata.coffee.ui.list.CoffeeList2;

public class CoffeeMain extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnOk;
	private JButton btnList2;
	private JButton btnList1;

	private JPanel subPanel;
	private CoffeePanel cp;
	private CoffeeList1 cl1;
	private CoffeeList2 cl2;
	private JPanel mainPanel;
	private JButton btnInint;
	private JButton btnImport;
	private JButton btnExport;
	private int checkCode = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoffeeMain frame = new CoffeeMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CoffeeMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		mainPanel = new JPanel();
		contentPane.add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));

		cp = new CoffeePanel();
		GridLayout gridLayout = (GridLayout) cp.getLayout();
		gridLayout.setColumns(4);
		gridLayout.setRows(0);
		mainPanel.add(cp, "name_31824294838809");

		subPanel = new JPanel();
		FlowLayout fl_subPanel = (FlowLayout) subPanel.getLayout();
		fl_subPanel.setVgap(10);
		fl_subPanel.setHgap(30);
		contentPane.add(subPanel, BorderLayout.SOUTH);

		btnOk = new JButton("입력");
		btnOk.addActionListener(this);
		subPanel.add(btnOk);

		btnList1 = new JButton("출력1");
		btnList1.addActionListener(this);
		subPanel.add(btnList1);

		btnList2 = new JButton("출력2");
		btnList2.addActionListener(this);
		subPanel.add(btnList2);

		btnInint = new JButton("초기화");
		btnInint.addActionListener(this);
		subPanel.add(btnInint);

		btnExport = new JButton("백업");
		btnExport.addActionListener(this);
		subPanel.add(btnExport);

		btnImport = new JButton("복원");
		btnImport.addActionListener(this);
		subPanel.add(btnImport);

		/* contentPane.add(cp, BorderLayout.CENTER); */

	}

	public PdtCode getPdtCodeObject() {
		String cfCode = cp.getTxtCode();

		String[][] codeList = { { "A001", "아메리카노" }, { "A002", "카푸치노" }, { "A003", "헤이즐넛" }, { "A004", "에스프레소" },
				{ "B001", "딸기쉐이크" }, { "B002", "후르츠와인" }, { "B003", "팥빙수" }, { "B004", "아이스초코" } };
		String cfName = null;

		for (int i = 0; i < codeList.length; i++) {

			if (codeList[i][0].equals(cfCode)) {
				cfName = codeList[i][1];
				cp.setTxtName(codeList[i][1]);
				checkCode = 1;
				break;
			}
		}
		;

		return new PdtCode(cfCode, cfName);
	}

	public PdtSale getPdtSaleObject() {
		String cfCode = cp.getTxtCode();
		int cfOne = cp.getTxtCfone();
		int cfSell = cp.getTxtSell();
		int cfMargin = cp.getTxtMargin();

		return new PdtSale(cfCode, cfOne, cfSell, cfMargin);
	}

	public void clearTf() {
		cp.setClearTxtCode();
		cp.setTxtName("");
		cp.setClearTxtCfone();
		cp.setClearTxtSell();
		cp.setClearTxtMargin();

	}

	// ?≪뀡由ъ뒪??
	public void actionPerformed(ActionEvent arg0) {
		ServiceSetting create = null;
		if (arg0.getSource() == btnExport) {
			create = new ExportSettingService();

			create.initSetting();
		}
		if (arg0.getSource() == btnInint) {
			create = new InitSettingService();

			create.initSetting();
		}
		if (arg0.getSource() == btnImport) {
			create = new ImportSettingService();

			create.initSetting();
		}
		if (arg0.getSource() == btnList1) {
			actionPerformedBtnList1(arg0);
		}
		if (arg0.getSource() == btnList2) {
			actionPerformedBtnList2(arg0);
		}
		if (arg0.getSource() == btnOk) {
			actionPerformedBtnNewButton(arg0);
		}

	}

	protected void actionPerformedBtnNewButton(ActionEvent e) {

		cp.setVisible(true);

		try {
			if (cl1.isVisible()) {
				cl1.setVisible(false);

			} else if (cl2.isVisible()) {
				cl2.setVisible(false);
			}
		} catch (Exception e2) {

		}

		try {

			if (cp.isVisible() == true) {
				PdtCode c = getPdtCodeObject();
				PdtSale s = getPdtSaleObject();

				if (checkCode == 0) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 제품 코드 입니다.");

				} else {
					CafeteriaDao.getInstance().insertTable(c);
					CafeteriaDao.getInstance().insertTable(s);

					JOptionPane.showMessageDialog(null, c.getCfName() + "추가 완료");
					clearTf();
				}

			}

		} catch (NumberFormatException e2) {

			JOptionPane.showMessageDialog(null, "새로운 판매 정보를 등록하세요.");

		}

	}

	protected void actionPerformedBtnList1(ActionEvent e) {

		cl1 = new CoffeeList1();
		mainPanel.add(cl1, "name_31824311102070");

		try {
			if (cp.isVisible()) {
				cp.setVisible(false);

			} else if (cl2.isVisible()) {
				cl2.setVisible(false);
			}
		} catch (Exception e2) {

		}
		cl1.setVisible(true);
		cl1.revalidate();
	}

	protected void actionPerformedBtnList2(ActionEvent e) {
		cl2 = new CoffeeList2();
		mainPanel.add(cl2, "name_31824327458798");
		try {
			if (cl1.isVisible()) {
				cl1.setVisible(false);

			} else if (cp.isVisible()) {
				cp.setVisible(false);
			}
		} catch (Exception e2) {

		}
		cl2.setVisible(true);
		cl2.revalidate(); 
	}

	protected void actionPerformedBtnImport(ActionEvent arg0) {
	}

	protected void actionPerformedBtnInint(ActionEvent arg0) {
	}

	protected void actionPerformedBtnExport(ActionEvent arg0) {
	}
}

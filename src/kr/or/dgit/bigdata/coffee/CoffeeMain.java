package kr.or.dgit.bigdata.coffee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.coffee.ui.CoffeePanel;
import kr.or.dgit.bigdata.coffee.ui.list.CoffeeList1;
import kr.or.dgit.bigdata.coffee.ui.list.CoffeeList2;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.CardLayout;

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
		mainPanel.add(cp, "name_31824294838809");
		cl1= new CoffeeList1();
		mainPanel.add(cl1, "name_31824311102070");
		cl2= new CoffeeList2();
		mainPanel.add(cl2, "name_31824327458798");
		cl2.setVisible(false);
		cl1.setVisible(false);
		
		
		subPanel = new JPanel();
		FlowLayout fl_subPanel = (FlowLayout) subPanel.getLayout();
		fl_subPanel.setVgap(10);
		fl_subPanel.setHgap(30);
		contentPane.add(subPanel, BorderLayout.SOUTH);
		
		btnOk = new JButton("입력");
		btnOk.addActionListener(this);
		subPanel.add(btnOk);
		
		btnList1 = new JButton("추가1");
		btnList1.addActionListener(this);
		subPanel.add(btnList1);
		
		btnList2 = new JButton("추가2");
		btnList2.addActionListener(this);
		subPanel.add(btnList2);
		
		/*contentPane.add(cp, BorderLayout.CENTER);*/
		
	}

	
	// ?≪뀡由ъ뒪??
	public void actionPerformed(ActionEvent arg0) {
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
		// ?대깽?몄뿉 ?곕씪 if臾?異붽?	
		cl1.setVisible(false);
		cl2.setVisible(false);
		cp.setVisible(true);
		
		
	}
	protected void actionPerformedBtnList1(ActionEvent e) {
		
		cp.setVisible(false);
		cl2.setVisible(false);	
		cl1.setVisible(true);
	}
	protected void actionPerformedBtnList2(ActionEvent e) {
		
		cp.setVisible(false);
		cl1.setVisible(false);
		cl2.setVisible(true);
		
	}
	
}

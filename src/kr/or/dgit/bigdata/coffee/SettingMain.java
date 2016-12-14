package kr.or.dgit.bigdata.coffee;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.bigdata.coffee.jdbc.CoffeeDbc;
import kr.or.dgit.bigdata.coffee.setting.ExportSettingService;
import kr.or.dgit.bigdata.coffee.setting.ImportSettingService;
import kr.or.dgit.bigdata.coffee.setting.InitSettingService;
import kr.or.dgit.bigdata.coffee.setting.ServiceSetting;

public class SettingMain extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JButton btnInit;
	private JButton btnBackup;
	private JButton btnRestore;
	
	
	public SettingMain() {
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0,20,0));
		
		btnInit = new JButton("초기화");
		btnInit.addActionListener(this);
		
		btnBackup = new JButton("백업");
		btnBackup.addActionListener(this);
		
		btnRestore = new JButton("복원");
		btnRestore.addActionListener(this);
		
		contentPane.add(btnInit);
		contentPane.add(btnBackup);
		contentPane.add(btnRestore);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ServiceSetting create = null;
		
		if (e.getSource() == btnRestore) {
			create = new ImportSettingService();
		} else if (e.getSource() == btnBackup) {
			create = new ExportSettingService();
		}else if (e.getSource() == btnInit) {
			create = new InitSettingService();
		}
		create.initSetting();

	}
	
	public static void main(String[] args) {
		SettingMain m = new SettingMain();
		m.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				CoffeeDbc.closeConnection();
			}
			
		});
		m.setVisible(true);
	}

}

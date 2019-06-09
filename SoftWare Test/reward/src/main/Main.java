package main;
import extra.RegMessage;
import prize.Prize;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	@SuppressWarnings("unused")
	private RegMessage RMS;
	private Register Rter;
	private Login Lg;
	@SuppressWarnings("unused")
	private Prize PZ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		JTextArea LoginName = new JTextArea();
		LoginName.setForeground(Color.BLACK);
		LoginName.setBounds(262, 120, 159, 24);
		frame.getContentPane().add(LoginName);
		
		JTextArea Password = new JTextArea();
		Password.setBounds(262, 203, 159, 24);
		frame.getContentPane().add(Password);
		
		JButton RegisterButton = new JButton("\u6CE8\u518C");
		RegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//添加主窗体的按键事件
		RegisterButton.addMouseListener(new MouseAdapter() 
		{
		
			@Override
			public void mousePressed(MouseEvent e)
			{
				String LName=LoginName.getText().toString();
				String PWord=Password.getText().toString();
				if(LName.isEmpty()||PWord.isEmpty()) 
				{
					RMS=new RegMessage("用户名或者密码不能为空!!!");
				}
				else//账号密码不为空，就判断
				{
					Rter=new Register(LName, PWord);
					Rter.run(LName, PWord);
				}
			}
			public void mouseReleased(MouseEvent e) {
				frame.requestFocus();//重新获取焦点
			}
		});
		
		RegisterButton.setBounds(168, 267, 113, 27);
		frame.getContentPane().add(RegisterButton);
		
		JButton LoginButton = new JButton("\u767B\u9646");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(!frame.isShowing());
				//PZ.setVisible(!PZ.isShowing());
			}
		});
		LoginButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				String LName=LoginName.getText().toString();
				String PWord=Password.getText().toString();
				if(LName.isEmpty()||PWord.isEmpty()) 
				{
					RMS=new RegMessage("用户名或者密码不能为空!!!");
				}
				else//账号密码不为空，就判断
				{
					Lg=new Login(LName, PWord);
					if(Lg.run(LName, PWord))//登陆成功后显示抽奖界面，隐藏原来的界面
					{
						frame.setVisible(false);;//隐藏原来的界面
						PZ=new Prize(frame,LName, PWord);//显示抽奖界面
			
					}
					
				}
			}
			public void mouseReleased(MouseEvent e) {
				frame.requestFocus();//重新获取焦点
				LoginName.setText(null);
				Password.setText(null);
			}
		});
		LoginButton.setBounds(329, 267, 113, 27);
		frame.getContentPane().add(LoginButton);
		
		JLabel lbla = new JLabel("\u767B\u9646\u540D");
		lbla.setBounds(156, 119, 136, 24);
		frame.getContentPane().add(lbla);
		
		JLabel label = new JLabel("\u5BC6\u7801");
		label.setBounds(156, 202, 136, 24);
		frame.getContentPane().add(label);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/0.png"));
		frame.setTitle("\u62BD\u5956\u7CFB\u7EDF");
		frame.setBounds(100, 100, 581, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

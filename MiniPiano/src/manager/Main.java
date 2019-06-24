package manager;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JTable;
import java.awt.Font;

public class Main {

	private JFrame frmPanioManager;
	@SuppressWarnings("unused")
	private JTable table;
	public String allCode="";
	public int nowcode[]= {};
	MyJPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
        
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmPanioManager.setVisible(true);
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
	private void initialize() {//初始化
		frmPanioManager = new JFrame();
		frmPanioManager.setIconImage((new ImageIcon("img/1.png")).getImage());//设置图标
		frmPanioManager.setTitle("Piano Manager");
		frmPanioManager.setResizable(false);
		frmPanioManager.setBounds(100, 100, 1409, 762);
		frmPanioManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPanioManager.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		
		//private int code ;  //键值
		panel= new MyJPanel();  	//存放所有按钮,加入88个组件
		frmPanioManager.getContentPane().add(panel);
		panel.setLayout(null);
		KeyMap mmp=new KeyMap();					//键值-组件序号对照表
		panel.setLayout(null);
		
		for(int i=0;i<88;i++) {//黑白键
			if(i<mmp.getWhiteNums())
				panel.getComponent(i).setBackground(Color.white);
			else
				panel.getComponent(i).setBackground(Color.black);
		}
		
		
		
		JTextPane textPane = new JTextPane();//显示按键
		textPane.setOpaque(false);
		//textPane.setBackground(new Color(0xf,255,255));
		textPane.setBackground(null);
		textPane.setFont(new Font("Adobe Caslon Pro Bold", Font.ITALIC, 28));
		textPane.setRequestFocusEnabled(false);
		textPane.setVerifyInputWhenFocusTarget(false);
		textPane.setEditable(false);
		textPane.setText("ready");
		textPane.setBounds(603, 393, 654, 287);		
		panel.add(textPane);
		
		
		
		//保存到数据库
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("");
				//allCode="";
				SaveData data=new SaveData(allCode);
				allCode="";
				textPane.setText("Save Successfully");
			}
			public void mousePressed(MouseEvent e) {
				//textPane.setText("Save Successfully");
				frmPanioManager.requestFocus();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				textPane.setText("");
				//allCode="";
				frmPanioManager.requestFocus();
			}
		});
		btnNewButton.setBounds(435, 403, 113, 27);
		btnNewButton.setBackground(Color.white);
		panel.add(btnNewButton);	
		btnNewButton.setBounds(458, 393, 113, 27);
		panel.add(btnNewButton);	
			
		
		
		//自动弹，sleep时窗体无响应，多线程，Swing是线程不安全的，sleep会阻塞UI线程，所以这个时候是不会看到按钮变化
		JButton btnAuto = new JButton("auto");
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int t1[]= {0,48,48,48,48,57,48,155,  48,57,57,57,0,0,  0,57,57,57,57,56,57,61, 57,56,55,56,56,55,   56,56,56,55,56,56,0,54,   56,56,56,55,56,56,0,54,	56,56,56,56,61,0,0,45,  57,0,0,48,0,45,    61,61,61,61,61,45,48,57,    57,56,56,56,0 , 0,48,45,   61,61,61,61,61,45,48,57,  57,48,56,56, 0,56,57,   48, 0, 0,56,48, 0, 0, 0,  48, 0, 0, 0, 0, 0,155,36,   73,73,79,73,36, 0,48,61,     155,155,61,45,61, 0,61,	61,61,61,45,45, 0,56,45,	61, 0,0,155,61,0,155,36,  73,73,79,73,36, 0,48,61,  155,155,61,45,61, 0, 0,61,    61,45,45,48,45, 0, 0,57, 0,  56, 0, 0, 0, 0, 0, 0, 0,   56, 0, 0, 0, 0, 0, 0, 0,  0};
				int t2[]= {49,0, 0, 0, 0, 0, 0, 0 ,  84,57, 0, 0,0,0,  81,0, 0, 0, 0, 0,74, 0, 72, 0, 0, 0, 0,56,  	87,	0, 0,56, 0, 0,0,55,	  69, 0, 0,56, 0, 0,0,55,	82, 0, 0, 0, 0,0,0,48,  84,0,0,84,0, 0,    70,81,84, 0,68,87,88, 0,    72,69,89,69,71,82,84,85,   70,81,82,89,68,74,87,88,  72,69,89,69,85,69,81,   83,72,81,67,89,87,89,49,  84,89,49,50,84,85,50, 0,	  89,51,54, 0,84,51,53, 0,     82 ,49 ,52,69,84,49,84, 	69,84,49,84,87,89,49,89,    87,82,84,82,81,69,84,69,  72,69,89,49,84,85,51,85,   82, 89,49,89,69,84,49, 0,    69, 0, 0, 0,87, 0, 0,44, 0,  72,69,89,69,85,69,49,69,   72,69,84,49, 0,85, 0,84, 89};
					new Thread(){//按键实时表现
						public void run(){
						try{
						}
						finally
						{
							String code="";
							for(int i=0;i<t1.length;i++) {
							if(mmp.mapcount(t1[i])) { 
								panel.down("now/"+t1[i]+".wav");
								panel.getComponent((int) mmp.mapget(t1[i])).setBackground(Color.blue);
			
								//System.out.print(" "+mmp.smapget(t1[i]));
								//textPane.setText(mmp.smapget(t1[i])+"");
								code+=mmp.smapget(t1[i])+"";
							}
							if(mmp.mapcount(t2[i])) {
								panel.down("now/"+t2[i]+".wav");
							//	System.out.println(" "+mmp.smapget(t2[i]));
								panel.getComponent((int) mmp.mapget(t2[i])).setBackground(Color.blue);
								code+=mmp.smapget(t2[i])+"";
							}
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for(int j=0;j<88;j++) {
								if(j<mmp.getWhiteNums())//白键数目
									panel.getComponent(j).setBackground(Color.white);
								else
									panel.getComponent(j).setBackground(Color.black);
							}
							code+=" ";
							if((i+1)%20==0)
								code+="\n";
							textPane.setText(code);
							}
						}
						}}.start();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmPanioManager.requestFocus();//重新获取焦点
			}
		});
		btnAuto.setBounds(290, 430, 113, 27);
		btnAuto.setBackground(Color.white);
		panel.add(btnAuto);
		
		
		
		//自动弹，sleep时窗体无响应，多线程
		JButton btnNewButton_1 = new JButton("沙漠骆驼");
		btnNewButton_1.setBounds(458, 430, 113, 27);
		btnNewButton_1.setBackground(Color.white);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
			
				//Object [][]
				int t1[]={	89,54,54,54,56,54,122,  	
						89,54,54,54,56,35, 
						89,54,54,54,56,54,0,		
						56,48,56,55,57,55,54,56,54,122,55,53, 
						89,56,56,56,48,55,		
						69,56,56,56,48,155,	
						89,56,56,56,48,122,
						57,70,55,56,54,55,53,54,52,	
					   122,70,51,51,49,51,49,50,85,
						88,68, 0, 0, 0,0,			
						 0,54,54,54,54,51,54,54,		 0,54,55,56,55,54,54,54,
						 0,54,54,54,54,54,54,81,		48, 0,48, 0,57,56,56, 0,				57,57,57,57,57,56,57,56,
						 0,56,56,56,56,56,56,55,		 0,55,55,55,55,55,55,55,				56, 0,56, 0,55,54,54, 0,
						 0,51,54,51,54,51,54,54,		 0,54,55,56,55,54,54,54,		
						 0,54,54,54,54,54, 0,54,		48,48, 0,57,56,56, 0,				    56,57,57,57,54,57,57,		 
						 0,56,56,56,56,54,56,55,		 0,55,55,55,54,55,55, 0,   				56, 0,56, 0,55,54,54, 0,		 
						 0,45,61,61,61,45,48,61,   		 0,155,155,155,155,155,48,155,155,       0,155,155,155,155,0,155,73,    
						 61, 0,61,61,48,56,56,0,   	     0,57,45,45,45,48,57,45,     			 0,57,48,48,48,57,56,48,                
			};
			int t2[]={72,54,122,55, 0,53,122,	
				      72,54,122,55, 0,48,	 
				      72,54,122,55,0,53,0,		
				      70,57, 0,71,56, 0,72,55, 0, 74,54, 0,
					  72,56,55,57,56, 0,		
					  68,56,55,57,33,  0,	
					  72,56,55,57,54,  0,
					  82,56,54,55,122,54,52,53,51,	82,52,52,50,50,85,49,89,
					  69, 0,0,0,0,0,				72,69,89,69,72,69,89,69,	68,74,69,74,68,74,69,74,
					  70, 0,81,82,81,70,81,82,		81,84,49,84,81,84,49,84,	83,72,87,72,83,72,87,72,
					  72,69,89,69,72,69,89,69,		68,74,69,74,68,74,69,74,	81,70,81,82,72,69,89,69,
					  72,69,89,69,72,69,89,69,		68,74,69,74,68,74,69,74,
					  68,81,82,81,68,81,82,81,		81,84,49,84,81,84,49,84,	83,72,87,72,83,72,87,72,	
					  72,69,89,69,72,69,89,69,		68,74,69,74,68,74,69,74,    68,81,82,81,72,69,89,69, 	
					  81,84,49,84,81,84,49,84,      68,74,69,74,68,74,69,74,    68,81,82,81,68,81,82,81,        
					  81,84,49,84,81,84,49,84,      83,72,87,72,83,72,87,72,    72,69,89,69,72,69,89,69,    
			};
			new Thread(){
						public void run(){
						try{
						}
						finally
						{
							String code="";
							for(int i=0;i<t1.length;i++) {
							if(mmp.mapcount(t1[i])) { 
								panel.down("now/"+t1[i]+".wav");
								panel.getComponent((int) mmp.mapget(t1[i])).setBackground(Color.blue);
			
							//	System.out.println("t1-i:"+i+" t1[i]: "+t1[i]+" "+mmp.smapget(t1[i])+'\n');
								//textPane.setText(mmp.smapget(t1[i])+"");
								code+=mmp.smapget(t1[i])+"";
							}
							if(mmp.mapcount(t2[i])) {
								panel.down("now/"+t2[i]+".wav");
								//System.out.println("t2-i:"+i+" t2[i]: "+t2[i]+" "+mmp.smapget(t2[i])+'\n');
								panel.getComponent((int) mmp.mapget(t2[i])).setBackground(Color.blue);
								code+=mmp.smapget(t2[i])+"";
							}
							try {
								Thread.sleep(280);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							for(int j=0;j<88;j++) {
								if(j<mmp.getWhiteNums())
									panel.getComponent(j).setBackground(Color.white);
								else
									panel.getComponent(j).setBackground(Color.black);
							}
							code+=" ";
							if((i+1)%20==0)
								code+="\n";
							textPane.setText(code);
							}
						}
						}}.start();
						
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmPanioManager.requestFocus();
			}
		});
		
		
		
		
		//数据库展示
		JButton btnShow = new JButton("show");
		btnShow.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			@Override
			public void mouseClicked(MouseEvent e) {
				ShowData she=new ShowData();
			}
		});
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPanioManager.requestFocus();
			}
		});
		btnShow.setBounds(290, 393, 113, 27);
		btnShow.setBackground(Color.white);
		panel.add(btnShow);
		
		
		
		
		//上部标题
		JLabel lblPiano = new JLabel("Piano");
		lblPiano.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 47));
		lblPiano.setBounds(608, 62, 234, 94);
		panel.add(lblPiano);
		
	
		
		//设置背景
		BackgroundPanel panel_1 = new BackgroundPanel((new ImageIcon("img/bg7.jpg")).getImage());
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(0, 0,this.frmPanioManager.getWidth(), this.frmPanioManager.getHeight());
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				textPane.setText("");
				allCode="";
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				frmPanioManager.requestFocus();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(288, 473, 113, 27);
		btnNewButton_2.setBackground(Color.white);
		panel_1.add(btnNewButton_2);
		
	
		
		
		frmPanioManager.setVisible(true);
		frmPanioManager.setFocusable(true);		//可以获取焦点
		frmPanioManager.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<88;i++) {
					if(i<mmp.getWhiteNums())
						panel.getComponent(i).setBackground(Color.white);
					else
						panel.getComponent(i).setBackground(Color.black);
				}

			}	
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				frmPanioManager.requestFocus();
				System.out.flush();
				int code=e.getKeyCode();
				//System.out.print(code);
				if(mmp.mapcount(code)) {
					panel.down("now/"+code+".wav");
					//System.out.println(mmp.smapget(code));
					panel.getComponent((int) mmp.mapget(code)).setBackground(Color.blue);
					allCode+=mmp.smapget(code)+" ";
					textPane.setText(allCode+"");
				}
			}
		});

	}
}

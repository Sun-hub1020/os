package prize;
import java.awt.Toolkit;
import javax.swing.JFrame;
import extra.RegMessage;
import main.Mysql;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Random;

@SuppressWarnings("serial")
public class Prize extends JFrame {
	private JFrame frame;
	private JFrame MainWindow;
	@SuppressWarnings("unused")
	private String NAME,PASS;
	@SuppressWarnings("unused")
	private RegMessage RMS;
	private Mysql my;
	public Prize(JFrame f,String N,String P) {
		MainWindow=f;
		my=new Mysql();
		NAME=N;
		PASS=P;
		init();
		
	}
	public void init() {
		frame= new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u62BD\u5956\u7CFB\u7EDF");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭时不涉及父窗口
		frame.setBounds(100, 100, 633, 326);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("img/0.png"));
		JButton button = new JButton("\u62BD\u5956");
		button.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(!frame.isShowing());
	             //   jf2.setVisible(!jf2.isShowing());
	        }
			@Override
			public void mousePressed(MouseEvent e) {
				 Random random = new Random();
				 int a=Math.abs(random.nextInt())%100;
				 int b=Math.abs(random.nextInt())%100;
				 if(a==b)
				 {
					 RMS=new RegMessage("恭喜您，中奖了!!!");
					// System.out.println("PZ"+" "+flag);
					 try {
						my.queryDone(NAME);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 }else
				 {
					 RMS=new RegMessage("很遗憾，您没有中奖!!!");
					// System.out.println("PZ"+" "+flag);
				 }
				 frame.setVisible(false);
				 MainWindow.setVisible(true);
			}
		
		});
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(130, 77, 329, 93);
		frame.getContentPane().add(button);
	}
}

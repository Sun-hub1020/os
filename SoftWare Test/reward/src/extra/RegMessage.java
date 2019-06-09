package extra;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Create the frame.该窗口用于提示用户各种信息
 *   包含注册信息，登陆信息，以及中奖信息
 */
@SuppressWarnings("serial")
public class RegMessage extends JFrame {
	private JFrame frame;
	private String str;
	public RegMessage(String st) {
		str=st;
		init();
	}
	
	public void init() {
		frame= new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭时不涉及父窗口
		frame.setBounds(100, 100, 391, 145);
		frame.getContentPane().setLayout(null);
		
		JLabel lbla = new JLabel(str);
		lbla.setFont(new Font("宋体", Font.PLAIN, 23));
		lbla.setBounds(25, 13, 301, 51);
		frame.getContentPane().add(lbla);
	}
}

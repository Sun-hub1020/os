package manager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class SaveData {

	 JFrame jf ;
	 public String steps;
	 // JTable table;
	  //定义二维数组作为表格数据
	  Object[][] tableData = { };
	  //定义一维数据作为列标题
	 // Object[] columnTitle = {"username" , "steps" };
	  public SaveData(String tt) {
		  this.init();
		  this.steps=tt;
		 // System.out.println(steps);
	  }
	  public void init()
	  {
		     jf = new JFrame();
			 //jf.setBounds(100, 100, 479, 366);
		     jf.getContentPane().setLayout(null);
			// jf.pack();
			// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			 jf.setVisible(true);
			 jf.setTitle("Saving");
			 jf.setResizable(false);
			 jf.setBounds(100, 100, 693, 487);
			 //jf.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
			 
		 JTextArea textArea = new JTextArea();
		 textArea.setBounds(157, 35, 104, 24);
		 jf.getContentPane().add(textArea);
		 
		 JButton btnSave = new JButton("save");
		 btnSave.setBounds(37, 82, 113, 27);
		 jf.getContentPane().add(btnSave);
		 
		 JLabel lblUsrname = new JLabel(" usrname");
		 lblUsrname.setBounds(57, 37, 72, 18);
		 jf.getContentPane().add(lblUsrname);
		 btnSave.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					 ConnectData  cnt=new ConnectData();
						try {
							//cnt.query("insert into users values('root',1,'dsad')");
							cnt.insert(textArea.getText(),steps);
							//弹窗
							JOptionPane.showMessageDialog(null, "Successfully!", "Saved", JOptionPane.PLAIN_MESSAGE);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				}
				public void mousePressed(MouseEvent e) {

				}
				@Override
				public void mouseExited(MouseEvent e) {

				}
			});

	  }
}

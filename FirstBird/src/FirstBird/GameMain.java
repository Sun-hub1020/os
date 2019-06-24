package FirstBird;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings({ "serial", "unused" })
public class GameMain extends javax.swing.JFrame {
	private WinJPanel jPanel1;

	/**
	* Auto-generated main method to display this JFrame
	 * @throws InterruptedException 
	*/
	public static void main(String[] args) throws InterruptedException {
		//SwingUtilities.invokeLater(new Runnable() {
		//	public void run() {
				AudioPlayWave bg=new AudioPlayWave ("bgm.wav");	//±≥æ∞“Ù¿÷
				GameMain inst = new GameMain();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				bg.start();
				inst.jPanel1.action(bg);
			}
	//	});
//	}
	
	public GameMain() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			{
				jPanel1 = new WinJPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
				jPanel1.setLayout(null);
			}
			pack();
			this.setSize(320, 480);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}

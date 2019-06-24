package manager;

import java.awt.Component;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

@SuppressWarnings("serial")
public class MyJPanel extends JPanel {
	public void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), Image.SCALE_DEFAULT);
		/*
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(),
				iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
				*/
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
	//public void paint(Graphics g) {
		// 绘制背景
	//	g.drawImage(new ImageIcon("img/bg.png").getImage(), 0, 0, null);
	//}
	public void action(AudioPlayWave bg) throws InterruptedException {
		// 添加窗体的鼠标点击的监听
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("Click on the Mouse!");
				//System.out.println(1);
			}
		});		
	}

	public void down(String file) {
		AudioPlayWave play=new AudioPlayWave (file);
		play.start();
	}
	
	
	//存放按钮
	public MyJPanel() {
		JButton button = new JButton("1");			//40-C-小字1组
		button.setBounds(621, 227, 17, 130);
		this.add(button);
		
		JButton button_0 = new JButton("2");		//42-D-小字1组
		button_0.setBounds(652, 227, 17, 130);
		this.add(button_0);
		
		JButton button_1 = new JButton("3");		//44-E-小字1组
		button_1.setBounds(683, 227, 17, 130);
		this.add(button_1);
		
		JButton button_2 = new JButton("4");		//45-F-小字1组
		button_2.setBounds(696, 227, 17, 130);
		this.add(button_2);
		
		JButton button_3 = new JButton("5");		//47-G-小字1组
		button_3.setBounds(727, 227, 17, 130);
		this.add(button_3);
		
		JButton button_4 = new JButton("6");		//49-A-小字1组
		button_4.setBounds(758, 227, 17, 130);
		this.add(button_4);
			
		JButton button_5 = new JButton("7");		//51-B-小字1组
		button_5.setBounds(794, 227, 17, 130);
		this.add(button_5);
		
		JButton button_6 = new JButton("8");
		button_6.setBounds(808, 227, 17, 130);
		this.add(button_6);
		
		JButton button_7 = new JButton("9");
		button_7.setBounds(839, 227, 17, 130);
		this.add(button_7);
		
		JButton button_8 = new JButton("0");
		button_8.setBounds(870, 227, 17, 130);
		this.add(button_8);
		
		JButton button_9 = new JButton("-");
		button_9.setBounds(887, 227, 17, 130);
		this.add(button_9);
		
		JButton button_10 = new JButton("=");
		button_10.setBounds(918, 227, 17, 130);
		this.add(button_10);
		
		JButton button_11 = new JButton("insert");
		button_11.setBounds(949, 227, 17, 130);
		this.add(button_11);
		
		JButton button_12 = new JButton("home");
		button_12.setBounds(980, 227, 17, 130);
		this.add(button_12);
		
		JButton button_13 = new JButton("Q");
		button_13.setBounds(435, 226, 17, 130);
		this.add(button_13);
		
		JButton button_14 = new JButton("W");
		button_14.setBounds(466, 227, 17, 130);
		this.add(button_14);
		
		JButton button_15 = new JButton("E");
		button_15.setBounds(497, 227, 17, 130);
		this.add(button_15);
		
		JButton button_16 = new JButton("R");
		button_16.setBounds(510, 227, 17, 130);
		this.add(button_16);
		
		JButton button_17 = new JButton("T");
		button_17.setBounds(541, 227, 17, 130);
		this.add(button_17);
		
		JButton button_18 = new JButton("Y");
		button_18.setBounds(572, 227, 17, 130);
		this.add(button_18);
		
		JButton button_19 = new JButton("U");
		button_19.setBounds(603, 227, 17, 130);
		this.add(button_19);
		
		JButton button_20 = new JButton("I");
		button_20.setBounds(994, 227, 17, 130);
		this.add(button_20);
		
		JButton button_21 = new JButton("O");
		button_21.setBounds(1025, 227, 17, 130);
		this.add(button_21);
		
		JButton button_22 = new JButton("P");
		button_22.setBounds(1056, 227, 17, 131);
		this.add(button_22);
		
		JButton button_23 = new JButton("[");
		button_23.setBounds(1073, 227, 17, 130);
		this.add(button_23);
		
		JButton button_24 = new JButton("]");
		button_24.setBounds(1104, 227, 17, 130);
		this.add(button_24);
		
		JButton button_25 = new JButton("\\");
		button_25.setBounds(1135, 227, 17, 130);
		this.add(button_25);
		
		JButton button_26 = new JButton("Del");
		button_26.setBounds(1166, 227, 17, 130);
		this.add(button_26);
		
		JButton button_27 = new JButton("A");
		button_27.setBounds(249, 227, 17, 130);
		this.add(button_27);
		
		JButton button_28 = new JButton("S");
		button_28.setBounds(280, 227, 17, 130);
		this.add(button_28);
		
		JButton button_29 = new JButton("D");
		button_29.setBounds(311, 227, 17, 130);
		this.add(button_29);
		
		JButton button_30 = new JButton("F");
		button_30.setBounds(324, 227, 17, 130);
		this.add(button_30);
		
		JButton button_31 = new JButton("G");
		button_31.setBounds(355, 227, 17, 130);
		this.add(button_31);
		
		JButton button_32 = new JButton("H");
		button_32.setBounds(386, 227, 17, 130);
		this.add(button_32);
		
		JButton button_33 = new JButton("J");
		button_33.setBounds(417, 227, 17, 130);
		this.add(button_33);
		
		JButton button_34 = new JButton("K");
		button_34.setBounds(63, 227, 17, 130);
		this.add(button_34);
		
		JButton button_35 = new JButton("L");
		button_35.setBounds(94, 227, 17, 130);
		this.add(button_35);
		
		JButton button_36 = new JButton(";");
		button_36.setBounds(125, 227, 17, 130);
		this.add(button_36);
		
		JButton button_37 = new JButton("'");
		button_37.setBounds(138, 227, 17, 130);
		this.add(button_37);
		
		JButton button_38 = new JButton(",");
		button_38.setBounds(169, 227,17, 130);
		this.add(button_38);
		
		JButton button_39= new JButton(".");
		button_39.setBounds(200, 227, 17, 130);
		this.add(button_39);
		
		JButton button_40 = new JButton("/");
		button_40.setBounds(231, 227, 17, 130);
		this.add(button_40);
		
		JButton button_41 = new JButton("M");
		button_41.setBounds(14, 227, 17, 130);
		this.add(button_41);
		
		JButton button_42 = new JButton("space");
		button_42.setBounds(45, 227, 17, 130);
		this.add(button_42);
		
		JButton button_43 = new JButton("Num_1");
		button_43.setBounds(1180, 228, 17, 129);
		this.add(button_43);
		
		JButton button_44 = new JButton("Num_2");
		button_44.setBounds(1211, 228, 17, 129);
		this.add(button_44);
		
		JButton button_45 = new JButton("Num_3");
		button_45.setBounds(1242, 227, 17, 130);
		this.add(button_45);
		
		JButton button_46 = new JButton("Num_4");
		button_46.setBounds(1259, 227, 17, 130);
		this.add(button_46);
		
		JButton button_47 = new JButton("Num_5");
		button_47.setBounds(1290, 227, 17, 130);
		this.add(button_47);
		
		JButton button_48 = new JButton("Num_6");
		button_48.setBounds(1321, 227, 17, 130);
		this.add(button_48);
		
		JButton button_49 = new JButton("Num_7");
		button_49.setBounds(1352, 227, 17, 130);
		this.add(button_49);
		
		JButton button_50 = new JButton("+");
		button_50.setBounds(1366, 227, 17, 130);
		this.add(button_50);
		
		JButton button_51 = new JButton("N");
		button_51.setBounds(32, 227, 17, 67);
		this.add(button_51);
		
		JButton button_52 = new JButton("B");
		button_52.setBounds(448, 227, 17, 67);
		this.add(button_52);
		
		JButton button_53 = new JButton("V");
		button_53.setBounds(479, 227, 17, 67);
		this.add(button_53);
		
		JButton button_54 = new JButton("C");
		button_54.setBounds(528, 227, 17, 67);
		this.add(button_54);
		
		JButton button_55 = new JButton("X");
		button_55.setBounds(559, 227, 17, 67);
		this.add(button_55);
		
		JButton button_56 = new JButton("Z");
		button_56.setBounds(590, 227, 17, 67);
		this.add(button_56);
		
		JButton button_57 = new JButton("Num_8");
		button_57.setBounds(1197, 227, 17, 67);
		this.add(button_57);
		
		JButton button_58 = new JButton("Num_9");
		button_58.setBounds(1228, 227, 17, 67);
		this.add(button_58);
		
		JButton button_59 = new JButton("Num_/");
		button_59.setBounds(1273, 227, 17, 67);
		this.add(button_59);
		
		JButton button_60 = new JButton("Num_*");
		button_60.setBounds(1304, 227, 17, 67);
		this.add(button_60);
		
		JButton button_61 = new JButton("Num_-");
		button_61.setBounds(1335, 227, 17, 67);
		this.add(button_61);
		
		JButton button_62 = new JButton("←");
		button_62.setBounds(1011, 227, 17, 67);
		this.add(button_62);
		
		JButton button_63 = new JButton("↓");
		button_63.setBounds(1042, 227, 17, 67);
		this.add(button_63);
		
		JButton button_64 = new JButton("→");
		button_64.setBounds(1087, 227, 17, 66);
		this.add(button_64);
		
		JButton button_65 = new JButton("Num_0");
		button_65.setBounds(1118, 227, 17, 66);
		this.add(button_65);
		
		JButton button_66 = new JButton("num_.");
		button_66.setBounds(1149, 227, 17, 67);
		this.add(button_66);
		
		JButton button_67 = new JButton("↑");
		button_67.setBounds(825, 227, 17, 67);
		this.add(button_67);
		
		JButton button_68 = new JButton("end");
		button_68.setBounds(856, 227, 17, 67);
		this.add(button_68);
		
		JButton button_69 = new JButton("pd");
		button_69.setBounds(901, 227, 17, 67);
		this.add(button_69);
		
		JButton button_70 = new JButton("pu");
		button_70.setBounds(932, 227, 17, 67);
		this.add(button_70);
		
		JButton button_71 = new JButton("pau");
		button_71.setBounds(963, 227, 17, 67);
		this.add(button_71);
		
		JButton button_72 = new JButton("back");

		button_72.setBounds(634, 227, 17, 67);
		this.add(button_72);
		
		JButton button_73 = new JButton("F12");
		button_73.setBounds(777, 227, 17, 67);
		this.add(button_73);
		
		JButton button_74 = new JButton("F11");
		button_74.setBounds(746, 227, 17, 67);
		this.add(button_74);
		
		JButton button_75 = new JButton("F10");
		button_75.setBounds(714, 227, 17, 67);
		this.add(button_75);
		
		JButton button_76 = new JButton("F9");
		button_76.setBounds(665, 227, 17, 67);
		this.add(button_76);
		
		JButton button_77 = new JButton("F8");
		button_77.setBounds(404, 226, 17, 67);
		this.add(button_77);
		
		JButton button_78 = new JButton("F7");
		button_78.setBounds(373, 227, 17, 67);
		this.add(button_78);
		
		JButton button_79 = new JButton("F6");
		button_79.setBounds(342, 227, 17, 67);
		this.add(button_79);
		
		JButton button_80 = new JButton("F5");
		button_80.setBounds(293, 227,17, 67);
		this.add(button_80);
		JButton button_81 = new JButton("F4");
		button_81.setBounds(262, 227, 17, 67);
		this.add(button_81);
		
		JButton button_82 = new JButton("F3");
		button_82.setBounds(156, 227, 17, 67);
		this.add(button_82);
		
		JButton button_83 = new JButton("F2");
		button_83.setBounds(107, 227, 17, 67);
		this.add(button_83);
		
		JButton button_84 = new JButton("F1");
		button_84.setBounds(76, 227, 17, 67);
		this.add(button_84);
		
		JButton button_85 = new JButton("~");
		button_85.setBounds(187, 227, 17, 67);
		this.add(button_85);
		
		JButton button_86 = new JButton("CS");
		button_86.setBounds(218, 227, 17, 67);
		this.add(button_86);
		
		this.setFocusTraversalPolicy(new FocusTraversalOnArray		//控制焦点遍历顺序/
				(new Component[]{
						button, button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, button_13, button_14, button_15, button_16, button_17, button_18, button_19, button_20, button_21, button_22, button_23, button_24, button_25, button_26, button_27, button_28, button_29, button_30, button_31, button_32, button_33, button_34, button_35, button_36, button_37, button_38, button_39, button_40, button_41, button_42, button_43, button_44, button_45, button_46, button_47, button_48, button_49, button_50, button_51, button_52, button_53, button_54, button_55, button_56, button_57, button_58, button_59, button_60, button_61, button_62, button_63, button_64, button_65, button_66, button_67, button_68, button_69, button_70, button_71, button_72, button_73, button_74, button_75, button_76, button_77, button_78, button_79, button_80, button_81, button_82, button_83, button_84, button_85, button_86
			}));
		
	}
}

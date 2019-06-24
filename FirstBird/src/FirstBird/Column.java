package FirstBird;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Column {
	int x;
	int y; 
	int speed=1;   //柱子移动速度
	Image img;     //柱子的图片
	Random rd;
	
	
	//绘制
	public void painter(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	//构造函数
	public Column(int gx) {
		x=gx;
		img=new ImageIcon("img/column.png").getImage();
		
		rd=new Random();
		y=-160+rd.nextInt(100);		//-160~-60
	}
	
	//移动
	public void move(int rank) {
		x-=(speed+rank);	//速度上升
		if(x<-58) {		//柱子图片的宽度
			x=320;		//窗体的长度
			y=-160+rd.nextInt(100);		//-160~-60 ,当整个柱子从窗体左侧穿过之后，则开始重新绘制下一个柱子
		}
	}
	
}

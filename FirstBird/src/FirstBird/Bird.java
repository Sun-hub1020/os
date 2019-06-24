package FirstBird;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bird {
	int x;
	int y;
	int i;  //指定bird的图片
	Image img;
	
	//绘制图片
	public void paint(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	//构造
	public Bird() {
		x=120;
		y=240;
		i=0;
		img=new ImageIcon("img/"+i+".png").getImage();
	}
	
	public void move() {
		y++;
		i++;
		i%=3;
		img=new ImageIcon("img/"+i+".png").getImage();
	}
	
	//碰撞函数
	public boolean hit(Column c1,Column c2) {
		//柱子高度为296，间隙长度为108，宽度为58
		//bird的宽度为38,高度为35(y轴方向)
		if(y<=0 ||y>=390) {		//顶部碰撞
			System.out.println("Hit the sky or the ground!!!");
			return true;
		}
		if(x+38>=c1.x &&x<=c1.x+58 &&(y<=c1.y+296 || y+35>=c1.y+296+108)) {
			//System.out.println("Hit the first Column!!!");
			return true;
		}
		if(x+38>=c2.x &&x<=c2.x+58 &&(y<=c2.y+296 || y+35>=c2.y+296+108)) {
			//System.out.println("Hit the second Column!!!");
			return true;
		}
		return false;
	}
	
	public boolean pass(Column c1,Column c2) {
		return x==c1.x+58 ||x==c2.x+58;
	}
	public void up() {
		AudioPlayWave play=new AudioPlayWave ("fei.wav");
		play.start();
	}
	public void down() {
		AudioPlayWave play=new AudioPlayWave ("deg.wav");
		play.start();
	}
}

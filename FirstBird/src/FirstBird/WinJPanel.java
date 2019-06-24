package FirstBird;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class WinJPanel extends JPanel {
	int xxx = 0;// 滚动条的横坐标
	int c = 160; // 两个柱子之间的间隔

	// 定义第一个柱子
	Column c1 = new Column(320 + 100);
	// 定义第二个柱子
	Column c2 = new Column(320 + 100 + c);
	// 定义bird
	Bird b1 = new Bird();
	boolean start = false;// 判断游戏是否开始
	boolean gameover = false;// 判断游戏是否结束，true则为结束
	int score=0;		//分数
	int rank=0;			//等级
	public void paint(Graphics g) {
		// 绘制背景
		g.drawImage(new ImageIcon("img/bg.png").getImage(), 0, 0, null);
		// 绘制滚动条
		g.drawImage(new ImageIcon("img/ground.png").getImage(), xxx, 400, null);
		// 柱子
		c1.painter(g);
		c2.painter(g);
		// 最后绘制bird，保证bird在柱子的前面，不会被覆盖
		b1.paint(g);
		
		//分数绘制
		Font font=new Font (Font.MONOSPACED,Font.BOLD,30);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Score: "+score, 30, 50);
		g.drawString("Rank: "+rank, 30, 80);
		// 绘制结束
		if (gameover) {
			g.drawImage(new ImageIcon("img/gameover.png").getImage(), 0, 0, null);
			//System.out.println("Gameover!");
			return; // 这里返回防止开始和结束画面重叠
		}
		// 绘制开始
		if (!start) {
			g.drawImage(new ImageIcon("img/start.png").getImage(), 0, 0, null);
			//System.out.println("GameStart!");
		}
	}

	@SuppressWarnings("deprecation")
	public void action(AudioPlayWave bg) throws InterruptedException {
		// 添加窗体的鼠标点击的监听
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				//System.out.println("Click on the Mouse!");
				//System.out.println(score);
				start = true; // 设置游戏状态为开始
				b1.y -= 30; // 点击鼠标，bird向上移动
				b1.up();	//飞起声音
				if(gameover) {
					score=0;
					rank=0;
					gameover=false;
					start=false;
					b1=new Bird();
					c1=new Column(320+100);
					c2=new Column(320+100+180);
					bg.resume();
				}
			}
		});
		while (true) {
			System.out.flush();
			if (start) {// 游戏开始
				// 柱子移动
				c1.move(rank);
				c2.move(rank);

				// bird的移动
				b1.move();

				// 如果撞击了，则游戏结束
				if (b1.hit(c1, c2)) {
					start = false;
					gameover = true;
					b1.down();
					bg.suspend();
				}
				if(b1.pass(c1, c2)) {
					score++;
					if(score%6==0)
						rank++;
				}
				
				xxx--; // 沿x粥移动
				if (xxx < -137) {
					xxx = 0;
				}
				repaint();
				Thread.sleep(1000/60);// 线程休眠，防止太快看不出移动
			}
		}
		//System.out.print(" ");
	}
}

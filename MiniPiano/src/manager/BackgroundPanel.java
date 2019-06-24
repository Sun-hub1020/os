package manager;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

class BackgroundPanel extends JPanel  
{  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image im;  
    public BackgroundPanel(Image im)  
    {  
        this.im=im;  
        this.setOpaque(true);                    //设置控件不透明
    }  
    
    //Draw the background again
    public void paintComponent(Graphics g)       //绘图类
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);   //动态获取面板大小	

    }  
}


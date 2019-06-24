package manager;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.SQLException;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowData {
	  JPopupMenu popupMenu;	
	  JFrame jf = new JFrame("");
	  public JTable table;
	  Object[][] tableData = new Object[][] {};
	  //定义一维数据作为列标题
	  Object[] columnTitle = {"username" , "ID","steps" };
	  public void init()
	  {
	    //以二维数组和一维数组来创建一个JTable对象
	    table = new JTable(tableData , columnTitle);
	    //将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
	    jf.getContentPane().add(new JScrollPane(table));    
	    jf.setTitle("ShowData");
	    jf.pack();
	    jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    jf.setVisible(true);
	    ///创建右键菜单
	    popupMenu = new JPopupMenu();
	    addPopup(table, popupMenu);
	    
	    JMenuItem delMenItem = new JMenuItem();	//右键项目
	    
	    delMenItem.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mousePressed(MouseEvent e) {
	    		
	    		
	    	}
	    });
	    
        delMenItem.setText("Loading");
        popupMenu.add(delMenItem);
	  }
	  public ShowData() {
		  ConnectData  cnt=new ConnectData();
			try {
				this.tableData=cnt.query("select * from users", true); //查询数据到表格
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    this.init();
	   
	  }
	
	private void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
				if (e.isMetaDown()) {
					int focusedRowIndex = table.rowAtPoint(e.getPoint());
		            if (focusedRowIndex == -1) {		//选中不能，
		                return;
		            }
		            //将表格所选项设为当前右键点击的行
		            table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
		            //弹出菜单
		            popupMenu.show(table, e.getX(), e.getY());
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

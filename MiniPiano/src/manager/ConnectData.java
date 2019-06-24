package manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * static {
		try {
		java.sql.DriverManager.registerDriver(new Driver());
		} catch (SQLException E) {
			throw new RuntimeException(“Can’t register driver!”);
		}
	}
	在Class.forName加载完驱动类，
	开始执行静态初始化代码时，会自动新建一个Driver的对象，
	并调用DriverManager.registerDriver把自己
	注册到DriverManager中去。之后便可以获取Connection;
 * */
/*在MYSQL中已经创建了一个名为pianousers的数据库，
 *在该数据库中创建了一个名为user的表   
 *   
 */
public class ConnectData {
	private static Connection connect=null;	//数据库连接对象
	private static String driver = "com.mysql.cj.jdbc.Driver"; //驱动
	private static String dbname="pianousers";		//所连接的数据库名称
	private static String url="jdbc:mysql://localhost:3306/"+dbname+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";;	//连接地址字符串
	private static String username= "root";  //数据库登陆用户名
	private static String password="root";	//数据库登陆密码
	//获取连接对象
	private static synchronized Connection getconnect() {
		System.setProperty(driver,"");
		if(connect==null) {//如果传入的连接不存在
			try {
				Class.forName(driver);
				connect=DriverManager.getConnection(url, username, password);  //和数据库连接
				System.out.println("Connect DataBase sucessfully!!");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Loading Driver failed,please check it import sucessfully!!");
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connect DataBase Failed!!");
			}
		}
		return connect;
	}
	public void insert(String user,String step) throws SQLException{		//SQL中insert语句
		String tt="insert into users(users,steps) values('"+user+"','"+step+"')";
		PreparedStatement pstmt;
        pstmt = getconnect().prepareStatement(tt);
        pstmt.execute();
        pstmt.close();
	}
	//执行查询语句
    public Object[][] query(String sql, boolean isSelect) throws SQLException{
    	
        PreparedStatement pstmt;
        Object[][]  tmp=new Object[1323][3];  	//临时保存
        int i=0;
        try {
            pstmt = getconnect().prepareStatement(sql);
            //建立一个结果集来存查询出来的结果
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
               //String name = rs.getString("name");
                //System.out.println(name);
            	/*测试数据
            	 * System.out.println("user : " + rs.getString(1) + " ID : "
                       + rs.getInt(2)+" steps :"+rs.getString(3));
                        */
            	tmp[i++]= new Object[] {rs.getString(1),rs.getInt(2)+"" ,rs.getString(3)};
            }
            rs.close();  		//关闭记录集
            pstmt.close();		//关闭声明
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tmp;
    }
    
    public void query(String sql) throws SQLException{
        PreparedStatement pstmt;
        pstmt = getconnect().prepareStatement(sql);
        pstmt.execute();
        pstmt.close();
    }
     
     
    //关闭连接对象
    public void close(){
        try {
            getconnect().close();
             
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

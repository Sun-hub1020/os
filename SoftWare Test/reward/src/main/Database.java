package main;

import java.sql.*; //导包

/*
 * 需要在本地创建一个名为prizers的数据库
 * 里面有两张表，一个是user,包含name(varchar-20)和password(varchar-20)两行，
 * user表存放的是已经注册过的用户
 * 另一个是user_wait，只包含name(varchar-20)一行，代表所有没有中过奖的用户群
 */
public class Database {

	private static Connection connect=null;	//数据库连接对象
	private static String driver = "com.mysql.cj.jdbc.Driver"; //驱动
	private static String dbname="prizers";		//所连接的数据库名称
	private static String url="jdbc:mysql://localhost:3306/"+dbname+"?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&autoReconnect=true";//连接地址字符串
	private static String username= "root";  //数据库登陆用户名
	private static String password="root";	//数据库登陆密码
   
	//获取连接对象
		public static synchronized Connection getconnect() {
			//System.setProperty(driver,"");
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
	    //关闭连接对象
	    public void close(){
	        try {
	            getconnect().close();
	             
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	}

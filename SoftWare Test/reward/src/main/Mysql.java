package main;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import extra.RegMessage;
public class Mysql {

    private Connection conn;//连接对象
    private Statement state;//传递
    private ResultSet setForLogin,setForReg,setForPrize;// 临时   +  结果
    /*
     * usr表中有三项
     * name,password
     * user_wait表中只包含未中过奖的用户
     * */
    public Mysql() {
    	conn=Database.getconnect();
    }
    //判断这个用户是否已经中过奖
    public void queryPrize(String name)throws SQLException{
    	String SQL="select * from user_wait where name ='"+name+"';";
		boolean flag=true;
    	try {
    		//此时已经是登陆后的，所以数据中一定存在该用户
    		conn=Database.getconnect();
    		state=conn.createStatement();
			setForPrize=state.executeQuery(SQL);
			if(setForPrize.next())
				flag=true;//未中过奖
			else
				flag=false;//中过奖
    	}finally {
			setForPrize.close();
			//conn.close();
		}
    	if(!flag) {
    		@SuppressWarnings("unused")
    		RegMessage passwordfail=new RegMessage("您已经中过奖，不能再次抽奖");
    	}
	//	return flag;//中过奖了
    }
    //将中奖的用户从待抽奖用户群中去除
    public void queryDone(String name)throws SQLException{
   		String SQL="delete from user_wait where name='"+name+"';";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
			state.executeUpdate(SQL);
    	}
    	finally {
			//conn.close();
    	}
    }
    //将用户加入待抽奖用户群
    public void queryAddWait(String name)throws SQLException{
    	String SQL="insert into user_wait values('"+name+"');";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
			state.executeUpdate(SQL);
    	}
    	finally {
			//conn.close();
    	}
    }
    //判断这个用户是否注册过了
    public boolean queryRegister(String name) throws SQLException {
    	String SQL="select * from user where name ='"+name+"';";
    	boolean flag=true;
    	try {
    		conn=Database.getconnect();
			state=conn.createStatement();
			setForReg=state.executeQuery(SQL);
			if(setForReg.next())
			{
				@SuppressWarnings("unused")
				RegMessage nameused=new RegMessage("用户名已经被使用！\n");
	        	flag=true;
			}else
				flag=false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//conn.close();
			setForReg.close();
		}
    	
    	return flag;//未注册
    }
    //将注册成功的用户加入数据库中
    public void queryAddNew(String name,String password) throws SQLException {
		String SQL="insert into user(name,password) values('"+name+"','"+password+"');";
    	try {
    		conn=Database.getconnect();
    		state=conn.createStatement();
    		state.executeUpdate(SQL);
    		@SuppressWarnings("unused")
    		RegMessage RegSuccess=new RegMessage("注册成功！\n");
    	}
    	finally {
			//conn.close();
    	}
    }
	//判断这个用户能否登陆成功
    public boolean queryLogin(String name,String password) {
    	String SQL="select * from user where name ='"+name+"';";
    	boolean flag=true;
    	try {
    	conn=Database.getconnect();
    	state=conn.createStatement();
    	setForLogin=state.executeQuery(SQL);
        if(!setForLogin.next()) {
        	@SuppressWarnings("unused")
			RegMessage namefail=new RegMessage("用户名不存在");
        	flag=false;
        }
        //获取对应用户名的密码
        if(flag && setForLogin.getString("password").compareTo(password)!=0) {
        	@SuppressWarnings("unused")
			RegMessage passwordfail=new RegMessage("密码错误");
        	flag=false;
        }
    	}catch (Exception e) {
            e.printStackTrace();
    	}finally {
            try {
            	//conn.close();
            	setForLogin.close(); 
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    	if(flag) {
    		@SuppressWarnings("unused")
			RegMessage passwordfail=new RegMessage("登陆成功");
    	}
    	return flag;
        //可以登陆
    }
     
}

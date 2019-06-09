# 0.环境

Eclipse(Version: Photon Release (4.8.0)--)+mysql(8.0.13)

# 1.数据库

 * 需要在本地创建一个名为prizers的数据库
 * 里面有两张表，一个是user,包含name(varchar-20)和password(varchar-20)两行，
 * user表存放的是已经注册过的用户
 * 另一个是user_wait，只包含name(varchar-20)一行，代表所有没有中过奖的用户群

# 2.结构

* extra包中的RegMessage用来显示各种信息
* main包中
  * Database用来连接数据库
  * Login是登陆按钮的相关事件
  * MySql是关于数据库的操作
  * Register是注册按钮的相关时间
  * Main是主窗体(main函数)
* prize包中的Prize是抽奖窗体


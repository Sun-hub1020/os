package main;

public class Login {
	private String N;
	private String P;
	private Mysql my;
	
	public Login(String LN,String PW) {
		N=LN;
		P=PW;
	}
	public boolean run(String LN,String PW) {
		my=new Mysql();
		return check();
	}
	public boolean check() {
		return my.queryLogin(N, P);	
	}
}

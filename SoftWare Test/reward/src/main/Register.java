package main;

import java.sql.SQLException;

public class Register {
	private String N;
	private String P;
	private Mysql my;
	public Register(String LN,String PW) {
		N=LN;
		P=PW;
	}
	public void run(String LN,String PW) {
		my=new Mysql();
		check();
	}
	public void check() {
		try {
			if(!my.queryRegister(N)) {
				my.queryAddNew(N, P);
				my.queryAddWait(N);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

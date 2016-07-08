package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = -7977398980046094392L;
	private String username;
	private String password;
	private String searchSql;
	private ResultSet rs;
	public LoginBean(){
		super();
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getUsername(){
		if(username == null || "".equals(username)){
			return "用户名为空，点击返回输入";
		}else{
			return "";
		}
	}
	public String getPassword(){
		if(password == null || "".equals(password)){
			return "密码为空，点击返回输入";
		}else{
			return "";
		}
	}
	public void setSearchSql(String searchSql){
		this.searchSql = searchSql;
	}
	public ResultSet getRs(){
		Connection conn = DBUtil.getConn();
		rs = DBUtil.getResultSet(conn, searchSql, this.username);
		if(rs == null)
			return null;
		else
			return rs;
	}
	//检查用户名是否输入
	public boolean checkUser(){
		if(username == null || "".equals(username)){
			return false;
		}else{
			return true;
		}
	}
	//检查密码是否输入
	public boolean checkPassword(){
		if(password == null || "".equals(password)){
			return false;
		}else{
			return true;
		}
	}
	//检查账号密码是否正确
	public boolean check(){
		ResultSet rs = getRs();
		try {
			String pass = null;
			while(rs != null && rs.next()){
				pass = rs.getString("password");
			}
			return password.equals(pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}

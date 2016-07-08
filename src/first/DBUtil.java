package first;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/dutphonelab?useUnicode=true&characterEncoding=UTF-8";  //数据库连接url	
	private static final String username = "root";
	private static final String password = "root";
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//返回数据库连接
	public static Connection getConn(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	//执行数据库查询SQL
	public static int getCount(Connection conn,String sql,Object... params){
		ResultSet rs = null;
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(int i = 0;i < params.length;i ++){
				pstmt.setObject(i+1,params[i]);
			}
			rs = pstmt.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return -1;
	}
	//执行数据库执行SQL
	public static ResultSet getResultSet(Connection conn,String sql,Object... params){
		ResultSet rs = null;
		try{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for(int i=0;i < params.length;i ++){
				pstmt.setObject(i+1, params[i]);
			}
			rs = pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	//执行数据库更新SQL
	public static int executeUpdate(Connection conn,String sql,Object... params){
		int rst = -1;    //定义更新操作的结果
		try{
			//创建会话
			PreparedStatement pstmt = conn.prepareStatement(sql); //循环设置参数
			for(int i = 0; i < params.length; i ++){
				pstmt.setObject(i + 1, params[i]);
			}
			rst = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rst;
	}
	//关闭结果集、会话和连接
	public static void close(Connection conn,Statement stmt,ResultSet rs){
		if(rs != null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try{
				stmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(conn !=  null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[]){
		DBUtil.getConn();
	}
}

package first;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/dutphonelab?useUnicode=true&characterEncoding=UTF-8";  //���ݿ�����url	
	private static final String username = "root";
	private static final String password = "root";
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	//�������ݿ�����
	public static Connection getConn(){
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	//ִ�����ݿ��ѯSQL
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
	//ִ�����ݿ�ִ��SQL
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
	//ִ�����ݿ����SQL
	public static int executeUpdate(Connection conn,String sql,Object... params){
		int rst = -1;    //������²����Ľ��
		try{
			//�����Ự
			PreparedStatement pstmt = conn.prepareStatement(sql); //ѭ�����ò���
			for(int i = 0; i < params.length; i ++){
				pstmt.setObject(i + 1, params[i]);
			}
			rst = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rst;
	}
	//�رս�������Ự������
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

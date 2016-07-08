package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;


public class deletePageBean implements Serializable {
	//随机产生的序列号码
	private static final long serialVersionUID = -7977398980046094392L;
	private int id;
	private String countSql;  //查询记录数的SQL
	private ResultSet rs;
	private Connection conn = null; //数据库连接
	//公开的默认构造方法
	public deletePageBean(){
		super();
	}
	//需要设置每页大小的构造方法
	public deletePageBean(int pageSize){
		this();
	}
	//等待Bean回收以后，记得关闭数据库连接
	@Override
	protected void finalize() throws Throwable{
		DBUtil.close(conn, null,rs);
	}
	public void setCountSql(String countSql){
		this.countSql = countSql + "where news_id = '"+id+"'";
	}
	public String getCountSql(){
		return countSql;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public int getRs(){
		//获取连接
		conn = DBUtil.getConn();
		//获取共有多少条记录
		int count = DBUtil.executeUpdate(conn,countSql);
		return count;
	}
}

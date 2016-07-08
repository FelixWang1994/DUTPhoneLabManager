package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;


public class ModifyPageBean implements Serializable {
	//随机产生的序列号码
	private static final long serialVersionUID = -7977398980046094392L;
	private int id;           //记录新闻id号
	private String countSql;  //查询记录数的SQL
	private String rsSql;     //查询结果的SQL
	private ResultSet rs;
	private Connection conn = null; //数据库连接
	private String username;    //记录编辑者姓名
	private String title;       //记录新闻标题
	private String abstractText; //记录新闻摘要
	private String newsContent; //记录新闻内容
	private Date date;
	//公开的默认构造方法
	public ModifyPageBean(){
		super();
	}
	//需要设置每页大小的构造方法
	public ModifyPageBean(int pageSize){
		this();
	}
	//等待Bean回收以后，记得关闭数据库连接
	@Override
	protected void finalize() throws Throwable{
		DBUtil.close(conn, null,rs);
	}
	public void setUsername(String username){
		this.username = username;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setAbstractText(String abstractText){
		this.abstractText = abstractText;
	}
	public void setNewsContent(String newsContent){
		this.newsContent = newsContent;
	}
	public void setDate(Date date){
		this.date = date;
	}
	public void setCountSql(String countSql){
		this.countSql = countSql + "UPDATE news set username='"+username+"',title='"+title+"',abstract='"+abstractText+"',newsContent='"+newsContent+"',date='"+date+"' where news_id = '"+id+"'";
	}
	public String getCountSql(){
		return this.countSql;
	}
	public void setRsSql(String rsSql){
		this.rsSql = rsSql + "where news_id = '"+id+"'";
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public ResultSet getResult(){
		conn = DBUtil.getConn();
		rs = DBUtil.getResultSet(conn, rsSql);
		return rs;
	}
	public int getRs(){
		//获取连接
		conn = DBUtil.getConn();
		//获取共有多少条记录
		int count = DBUtil.executeUpdate(conn,countSql);
		return count;
	}
}

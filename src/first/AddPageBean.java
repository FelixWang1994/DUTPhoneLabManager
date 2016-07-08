package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;


public class AddPageBean implements Serializable {
	//随机产生的序列号码
	private static final long serialVersionUID = -7977398980046094392L;
	private int id;
	private String countSql;  //查询记录数的SQL
	private ResultSet rs;
	private Connection conn = null; //数据库连接
	private String username;    //记录编辑者姓名
	private String title;       //记录新闻标题
	private String abstractText; //记录新闻摘要
	private String newsContent; //记录新闻内容
	private Date date;
	//公开的默认构造方法
	public AddPageBean(){
		super();
	}
	//需要设置每页大小的构造方法
	public AddPageBean(int pageSize){
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
		this.countSql = countSql + "insert into news values ('0','"+username+"','"+title+"','"+abstractText+"','"+newsContent+"','"+date+"')";
	}
	public String getCountSql(){
		return this.countSql;
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

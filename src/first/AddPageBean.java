package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;


public class AddPageBean implements Serializable {
	//������������к���
	private static final long serialVersionUID = -7977398980046094392L;
	private int id;
	private String countSql;  //��ѯ��¼����SQL
	private ResultSet rs;
	private Connection conn = null; //���ݿ�����
	private String username;    //��¼�༭������
	private String title;       //��¼���ű���
	private String abstractText; //��¼����ժҪ
	private String newsContent; //��¼��������
	private Date date;
	//������Ĭ�Ϲ��췽��
	public AddPageBean(){
		super();
	}
	//��Ҫ����ÿҳ��С�Ĺ��췽��
	public AddPageBean(int pageSize){
		this();
	}
	//�ȴ�Bean�����Ժ󣬼ǵùر����ݿ�����
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
		//��ȡ����
		conn = DBUtil.getConn();
		//��ȡ���ж�������¼
		int count = DBUtil.executeUpdate(conn,countSql);
		return count;
	}
}

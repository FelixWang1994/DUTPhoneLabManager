package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;


public class deletePageBean implements Serializable {
	//������������к���
	private static final long serialVersionUID = -7977398980046094392L;
	private int id;
	private String countSql;  //��ѯ��¼����SQL
	private ResultSet rs;
	private Connection conn = null; //���ݿ�����
	//������Ĭ�Ϲ��췽��
	public deletePageBean(){
		super();
	}
	//��Ҫ����ÿҳ��С�Ĺ��췽��
	public deletePageBean(int pageSize){
		this();
	}
	//�ȴ�Bean�����Ժ󣬼ǵùر����ݿ�����
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
		//��ȡ����
		conn = DBUtil.getConn();
		//��ȡ���ж�������¼
		int count = DBUtil.executeUpdate(conn,countSql);
		return count;
	}
}

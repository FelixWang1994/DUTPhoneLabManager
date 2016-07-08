package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;

public class SearchPageBean implements Serializable {
	// ������������к���
	private static final long serialVersionUID = -7977398980046094392L;
	private int currentPage; // ��ǰҳ��
	private int maxPage; // ��ҳ��
	private int pageSize; // ÿҳ��С
	private boolean hasNext; // �Ƿ������һҳ
	private boolean hasPrevious; // �Ƿ������һҳ
	private ResultSet rs; // �����
	private String keyword; // ���ڲ�ѯ���ŵĹؼ���
	private String countSql; // ��ѯ��¼����SQL
	private String rsSql; // ��ѯ�������SQL
	private Connection conn = null; // ���ݿ�����

	// ������Ĭ�Ϲ��췽��
	public SearchPageBean() {
		super();
		currentPage = 1;
	}

	// ��Ҫ����ÿҳ��С�Ĺ��췽��
	public SearchPageBean(int pageSize) {
		this();
		this.pageSize = pageSize;
	}

	// ���ڲ���
	// ��ȡ��������Ȼ�ȡ���ж�������¼���ٻ�ȡ�����
	public ResultSet getRs() {
		if (rs != null)
			return rs;
		// ��ȡ����
		conn = DBUtil.getConn();
		// ��ȡ���ж�������¼
		int count = DBUtil.getCount(conn, countSql);
		// ���û�м�¼��ֱ�ӷ���null
		if (count < 1)
			return null;
		// ��������ҳ��
		maxPage = (count - 1) / pageSize + 1;
		// �����ǰҳΪ���ҳ�룬��������һҳ
		if (currentPage == maxPage) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// �����ǰҳΪ1����������һҳ
		if (currentPage == 1) {
			hasPrevious = false;
		} else {
			hasPrevious = true;
		}
		// ��ȡ�����
		rs = DBUtil.getResultSet(conn, rsSql);
		return rs;
	}

	// ���õ�ǰҳ
	public void setCurrentPage(int currentPage) {
		if (currentPage < 1)
			currentPage = 1;
		this.currentPage = currentPage;
	}

	// ��ȡ��һҳ�ı�,���û�����ǿ�
	public String getFirstPageText() {
		if (currentPage != 1)
			return "��һҳ";
		else
			return "";
	}

	// ��ȡ��һҳ��
	public int getPrePage() {
		return currentPage - 1;
	}

	// ��ȡ��һҳ�ı������û�����ǿ�
	public String getPrePageText() {
		if (hasPrevious)
			return "��һҳ";
		else
			return "";
	}

	// ��ȡ��һҳ��
	public int getNextPage() {
		return currentPage + 1;
	}

	// ��ȡ��һҳ�ı������û�����ǿ�
	public String getNextPageText() {
		if (hasNext)
			return "��һҳ";
		else
			return "";
	}

	// ��ȡ���һҳ�ı������û�����ǿ�
	public String getLastPageText() {
		if (hasNext)
			return "���ҳ";
		else
			return "";
	}

	// �ȴ�Bean�����Ժ󣬼ǵùر����ݿ�����
	@Override
	protected void finalize() throws Throwable {
		DBUtil.close(conn, null, rs);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql + " where title like '%" + keyword
				+ "%' or newsContent like '%" + keyword + "%'";
	}

	public void setRsSql(String rsSql) {
		int start = ((currentPage - 1) * pageSize);
		String limit = " limit " + start + "," + pageSize;
		this.rsSql = rsSql + " where title like '%" + keyword
				+ "%' or newsContent like '%" + keyword + "%'";
		this.rsSql += limit;
	}

	public String getRsSql() {
		return this.rsSql;
	}
}

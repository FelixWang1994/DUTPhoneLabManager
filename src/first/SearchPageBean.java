package first;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;

public class SearchPageBean implements Serializable {
	// 随机产生的序列号码
	private static final long serialVersionUID = -7977398980046094392L;
	private int currentPage; // 当前页码
	private int maxPage; // 总页数
	private int pageSize; // 每页大小
	private boolean hasNext; // 是否存在下一页
	private boolean hasPrevious; // 是否存在上一页
	private ResultSet rs; // 结果集
	private String keyword; // 用于查询新闻的关键字
	private String countSql; // 查询记录数的SQL
	private String rsSql; // 查询结果集的SQL
	private Connection conn = null; // 数据库连接

	// 公开的默认构造方法
	public SearchPageBean() {
		super();
		currentPage = 1;
	}

	// 需要设置每页大小的构造方法
	public SearchPageBean(int pageSize) {
		this();
		this.pageSize = pageSize;
	}

	// 用于查找
	// 获取结果集，先获取共有多少条记录，再获取结果集
	public ResultSet getRs() {
		if (rs != null)
			return rs;
		// 获取连接
		conn = DBUtil.getConn();
		// 获取共有多少条记录
		int count = DBUtil.getCount(conn, countSql);
		// 如果没有记录，直接返回null
		if (count < 1)
			return null;
		// 计算最大的页码
		maxPage = (count - 1) / pageSize + 1;
		// 如果当前页为最大页码，则不能有下一页
		if (currentPage == maxPage) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// 如果当前页为1，则不能有上一页
		if (currentPage == 1) {
			hasPrevious = false;
		} else {
			hasPrevious = true;
		}
		// 获取结果集
		rs = DBUtil.getResultSet(conn, rsSql);
		return rs;
	}

	// 设置当前页
	public void setCurrentPage(int currentPage) {
		if (currentPage < 1)
			currentPage = 1;
		this.currentPage = currentPage;
	}

	// 获取第一页文本,如果没有则是空
	public String getFirstPageText() {
		if (currentPage != 1)
			return "第一页";
		else
			return "";
	}

	// 获取上一页码
	public int getPrePage() {
		return currentPage - 1;
	}

	// 获取上一页文本，如果没有则是空
	public String getPrePageText() {
		if (hasPrevious)
			return "上一页";
		else
			return "";
	}

	// 获取下一页码
	public int getNextPage() {
		return currentPage + 1;
	}

	// 获取下一页文本，如果没有则是空
	public String getNextPageText() {
		if (hasNext)
			return "下一页";
		else
			return "";
	}

	// 获取最后一页文本，如果没有则是空
	public String getLastPageText() {
		if (hasNext)
			return "最后页";
		else
			return "";
	}

	// 等待Bean回收以后，记得关闭数据库连接
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

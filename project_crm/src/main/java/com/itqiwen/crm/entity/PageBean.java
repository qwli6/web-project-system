package com.itqiwen.crm.entity;

import java.util.List;

/**
 * 分页
 */
public class PageBean<T> {
	
	// 当前页
	private int pageCode;
	
	// 总页数
	// private int totalPage;
	
	// 总记录数
	private int totalCount;
	// 每页显示的记录条数
	private int pageSize;
	// 每页显示的数据
	private List<T> beanList;
	
	public int getPageCode() {
		return pageCode;
	}
	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}
	
	/**
	 * 调用 getTotalPage() 获取到总页数
	 * @return 返回总页数
	 */
	public int getTotalPage() {
		// 计算
		int totalPage = totalCount / pageSize;
		// 说明整除
		if(totalCount % pageSize == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	
	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

	@Override
	public String toString() {
		return "PageBean{" +
				"pageCode=" + pageCode +
				", totalCount=" + totalCount +
				", pageSize=" + pageSize +
				", beanList=" + beanList +
				'}';
	}
}

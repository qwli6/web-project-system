package com.itqiwen.crm.entity;

import java.util.List;

/**
 * 分页
 */
public class PageBean<T> {
	
	private int pageCode;
	private int totalCount;
	private int pageSize;
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

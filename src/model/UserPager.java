package model;

import java.util.List;

public class UserPager {
	public UserPager() {	
		
	}
	
	private int currentPage;
	private int pageSum;
	private List<User> list;

	public UserPager(int currentPage, int pageSum, List<User> list) {
		this.currentPage = currentPage;
		this.pageSum = pageSum;
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSum() {
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
}

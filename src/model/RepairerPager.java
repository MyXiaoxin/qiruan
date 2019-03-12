package model;

import java.util.List;

public class RepairerPager {
	private int currentPage;
	private int pageSum;
	private List<Repairer> list;
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
	public List<Repairer> getList() {
		return list;
	}
	public void setList(List<Repairer> list) {
		this.list = list;
	}
	public RepairerPager(int currentPage, int pageSum, List<Repairer> list) {
		super();
		this.currentPage = currentPage;
		this.pageSum = pageSum;
		this.list = list;
	}
	public RepairerPager() {
		
	}
}

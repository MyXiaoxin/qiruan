package model;

import java.util.List;

import entity.Baoxiudan;

public class Pager {

	public Pager() {
		
	}
	private int paeSize;
	private int currentPage;
	private List<Baoxiudan> data;
	
	
	public int getPaeSize() {
		return paeSize;
	}
	public void setPaeSize(int paeSize) {
		this.paeSize = paeSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Baoxiudan> getData() {
		return data;
	}
	public void setData(List<Baoxiudan> data) {
		this.data = data;
	}
	public Pager(int paeSize, int currentPage, List<Baoxiudan> data) {
		super();
		this.paeSize = paeSize;
		this.currentPage = currentPage;
		this.data = data;
	}
	
	
	
	
	
	

}

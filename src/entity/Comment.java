package entity;

public class Comment {
	private int wxd_id;
	private int id;
	private String comment;
	private String star;
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
	public int getWxd_id() {
		return wxd_id;
	}
	public void setWxd_id(int wxd_id) {
		this.wxd_id = wxd_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}

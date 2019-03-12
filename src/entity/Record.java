package entity;

public class Record {
	private int id;
	private String typeText;//类型
    private String state;//状态
    private String detailsText;//详情
    private String time;
    private String  imageUrl;//图片
    
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeText() {
		return typeText;
	}
	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDetailsText() {
		return detailsText;
	}
	public void setDetailsText(String detailsText) {
		this.detailsText = detailsText;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}

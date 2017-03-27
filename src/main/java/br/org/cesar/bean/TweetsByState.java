package br.org.cesar.bean;

public class TweetsByState {
	private String state;
    private Integer qty;
    
	public TweetsByState(String state, Integer qty) {
		super();
		this.state = state;
		this.qty = qty;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
    
}

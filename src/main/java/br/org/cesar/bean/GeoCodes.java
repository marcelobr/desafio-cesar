package br.org.cesar.bean;

public class GeoCodes {
	
	private String state;
	private Double latitude;
	private Double longitude;
	private Double raio;
	
	public GeoCodes(String state, Double latitude, Double longitude, Double raio) {
		super();
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		this.raio = raio;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getRaio() {
		return raio;
	}
	public void setRaio(Double raio) {
		this.raio = raio;
	}
	
}

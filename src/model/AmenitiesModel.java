package model;

public class AmenitiesModel {
	private int amid;

	public AmenitiesModel(String amenities) {

		this.amenities = amenities;
	}

	public int getAmid() {
		return amid;
	}

	public void setAmid(int amid) {
		this.amid = amid;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	private String amenities;
}

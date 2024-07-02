package model;

public class AreaMasterModel extends CityMasterModel{
	private int arId;
	private String areaName;

	public AreaMasterModel() {

	}

	public AreaMasterModel(String areaName) {
		this.areaName = areaName;
	}

	public int getArId() {
		return arId;
	}

	public void setArId(int arId) {
		this.arId = arId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

}

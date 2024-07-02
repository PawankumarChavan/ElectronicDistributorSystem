package model;

import dbConfig.DBHelper;

public class CityMasterModel {
	private int id;
	private String name;

	public CityMasterModel() {

	}

	public CityMasterModel(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}

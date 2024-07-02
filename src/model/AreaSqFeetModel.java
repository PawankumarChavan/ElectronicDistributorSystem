package model;

public class AreaSqFeetModel {
	private int sqid;
	private int sqfeet;

	public AreaSqFeetModel(int sqfeet) {
		
		this.sqfeet = sqfeet;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
	}

	public int getSqfeet() {
		return sqfeet;
	}

	public void setSqfeet(int sqfeet) {
		this.sqfeet = sqfeet;
	}
}

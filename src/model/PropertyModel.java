package model;

public class PropertyModel {

	private int pid;
	private String address;
	private AreaMasterModel ammodel;
	private AreaSqFeetModel aSqM;
	private int nbed;
	private int nbath;
	private AmenitiesModel am[];
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AreaMasterModel getAmmodel() {
		return ammodel;
	}
	public void setAmmodel(AreaMasterModel ammodel) {
		this.ammodel = ammodel;
	}
	public AreaSqFeetModel getaSqM() {
		return aSqM;
	}
	public void setaSqM(AreaSqFeetModel aSqM) {
		this.aSqM = aSqM;
	}
	public int getNbed() {
		return nbed;
	}
	public void setNbed(int nbed) {
		this.nbed = nbed;
	}
	public int getNbath() {
		return nbath;
	}
	public void setNbath(int nbath) {
		this.nbath = nbath;
	}
	public AmenitiesModel[] getAm() {
		return am;
	}
	public void setAm(AmenitiesModel[] am) {
		this.am = am;
	}
	
}

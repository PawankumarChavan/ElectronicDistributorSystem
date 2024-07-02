package service;

import model.AreaMasterModel;
import model.CityMasterModel;
import repo.CityRepo;

import java.sql.SQLException;
import java.util.*;
public class CityService {
	List<CityMasterModel> list = new ArrayList<>();
	ArrayList<String> list1=new ArrayList<>();
	CityRepo cr = new CityRepo();
	public boolean isAddCity(CityMasterModel cmodel) {
		boolean b =cr.isAddCity(cmodel);
		return b;
	}
	
	public List<CityMasterModel> getCityList(CityMasterModel model) throws SQLException {
		list= cr.getCityList(model);
		return list;
	}
	
	public boolean addBulkCities(CityMasterModel cmodel) {
		return cr.addBulkCities(cmodel);
	}

	public int getCityId(String cname) {
		return cr.getCityId(cname);
	}
	
	public int getAreaIDAuto() {
		return cr.getAreaIDAuto();
	}
	
	public boolean isAddAr(AreaMasterModel am) {
		return cr.isAddArea(am);
	}
	
	public LinkedHashMap<String, Integer> getCityWiseAreaCount(){
		return this.cr.getCityWiseAreaCount();
	}
	
	public String getCityNameById(int id) {
		return cr.getCityNameById(id);
	}
	
	public LinkedHashMap<String,ArrayList<String>> getCityWiseAreas(){
		return this.cr.getCityWiseAreas();
	}

	public ArrayList<String> getCityList(int cid) {
		list1=cr.getAreaList(cid);
		return list1;
	}
}

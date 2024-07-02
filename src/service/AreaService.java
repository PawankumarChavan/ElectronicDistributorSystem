package service;

import model.AreaMasterModel;
import repo.AreaRepo;

public class AreaService {
	AreaRepo arpo = new AreaRepo();
	
	public boolean addArea(AreaMasterModel am,String city) {
		return arpo.isAddArea(am,city);
	}
}

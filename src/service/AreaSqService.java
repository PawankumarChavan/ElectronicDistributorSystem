package service;

import model.AreaSqFeetModel;
import repo.AreaSqRepo;

public class AreaSqService {
	AreaSqRepo asr= new AreaSqRepo();

	public boolean isAddSqFeet(AreaSqFeetModel asfm) {
		return asr.isAddSqF(asfm);
	}
}

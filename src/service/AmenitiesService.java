package service;

import model.AmenitiesModel;
import repo.AmenitiesRepo;

public class AmenitiesService {
	AmenitiesRepo amrepo=new AmenitiesRepo();

	public boolean isAddAmenities(AmenitiesModel ameMod) {
		return amrepo.isAddAmenities(ameMod);
	}
}

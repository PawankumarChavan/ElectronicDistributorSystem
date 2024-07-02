package repo;

import dbConfig.DBHelper;
import model.AmenitiesModel;

public class AmenitiesRepo extends DBHelper {

	public boolean isAddAmenities(AmenitiesModel ameMod) {
		try {
			pst = cn.prepareStatement("insert into amenities values('0',?)");
			pst.setString(1, ameMod.getAmenities());
			int val = pst.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

}

package repo;

import dbConfig.DBHelper;
import model.AreaSqFeetModel;

public class AreaSqRepo extends DBHelper {

	public boolean isAddSqF(AreaSqFeetModel asfm) {
		try {
			pst = cn.prepareStatement("insert into sqMaster values('0',?)");
			pst.setInt(1, asfm.getSqfeet());
			int val = pst.executeUpdate();
			return val > 0 ? true : false;

		} catch (Exception ex) {
			return false;
		}
	}

}

package repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import dbConfig.DBHelper;
import dbConfig.PathHelper;
import model.AreaMasterModel;
import model.CityMasterModel;

public class AreaRepo extends DBHelper {
	int val = 0;
	CityMasterModel cm = new CityMasterModel();
	CityRepo cr = new CityRepo();

	public boolean isAddArea(AreaMasterModel am, String city) {
		try {
			pst = cn.prepareStatement("insert into areaMaster values('0',?)");
			pst.setString(1, am.getAreaName());
			val = pst.executeUpdate();
			if (val > 0) {

				PreparedStatement pst1 = cn.prepareStatement("insert into cityAreaJoin values(?,?)");
//				pst=cn.prepareStatement();
				pst1.setInt(1, cr.getCityId(city));
				pst1.setInt(2, am.getArId());
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}
}

package repo;

import dbConfig.DBHelper;
import model.AreaMasterModel;
import model.CityMasterModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.cj.jdbc.CallableStatement;

public class CityRepo extends DBHelper {
	private List<Object[]> cityWiseAreaCountList;
	int val = 0;
	private int areaid = 0;
	private LinkedHashMap<String, Integer> map;
	private LinkedHashMap<String,ArrayList<String>> map1;
	public boolean isAddCity(CityMasterModel model) {
		try {
			pst = cn.prepareStatement("insert into cityMaster values ('0',?)");
			pst.setString(1, model.getName());
			int val = pst.executeUpdate();
			return val > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Exception");
			return false;
		}

	}

	public List<CityMasterModel> getCityList(CityMasterModel model) throws SQLException {
		List<CityMasterModel> al = new ArrayList<>();
		pst = cn.prepareStatement("select * from cityMaster");
		rs = pst.executeQuery();
		while (rs.next()) {
			CityMasterModel m = new CityMasterModel();
			m.setId(rs.getInt(1));
			m.setName(rs.getString(2));

			al.add(m);
		}

		return al.size() > 0 ? al : null;
	}

	public boolean addBulkCities(CityMasterModel cm) 
	{
		try {
			FileReader fr = new FileReader("D:\\cities.csv");
			BufferedReader br = new BufferedReader(fr);
			String temp = "";

			while ((temp = br.readLine()) != null) {
				String args[] = temp.split(",");
				pst = cn.prepareStatement("insert into cityMaster values(?,?)");
				int tid = Integer.parseInt(args[0]);
				pst.setInt(1, tid);
				pst.setString(2, args[1]);
				val = pst.executeUpdate();
			}
			if (val > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	public int getCityId(String cname) {
		try {
			pst = cn.prepareStatement("select cid from cityMaster where cname=?");
			pst.setString(1, cname);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception ex) {
			return 0;
		}
	}
	
	public String getCityNameById(int id) 
	{
		try {
			pst = cn.prepareStatement("select cname from cityMaster where cid=?");
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			} else {
				return null;
			}
		} catch (Exception ex) {
			return null;
		}
	}

	public int getAreaIDAuto() {
		try {
			pst = cn.prepareStatement("select max(areaid) from areamaster");
			if (rs.next()) {
				this.areaid = rs.getInt(1);
			}
			++areaid;
			return areaid;
		} catch (Exception ex) {
			return 0;
		}
//		return -1;
	}

	public boolean isAddArea(AreaMasterModel am) {
		try {
			CallableStatement stmt = (CallableStatement) cn.prepareCall("{call savearea(?,?,?)}");
			stmt.setInt(1, am.getArId());
			stmt.setString(2, am.getAreaName());
			stmt.setInt(3, am.getId());
			boolean b1 = stmt.execute(); // if executes returns false
			return !b1;
		} catch (Exception ex) {
			return false;
		}

	}

//	public List<Object[]> getCityWiseAreaCount(){
//		try {
//			this.cityWiseAreaCountList=new ArrayList<Object[]>();
//			pst=cn.prepareStatement("select c.cname,count(acj.areaid) from cityareajoin acj inner join citymaster c on acj.cid=c.cid inner join areamaster am on acj.areaid=am.areaid group by c.cname");
//			rs=pst.executeQuery();
//			while(rs.next()) {
//				Object obj[]=new Object[] {rs.getString(1),rs.getInt(2)};
//				this.cityWiseAreaCountList.add(obj);
//			}
//			return this.cityWiseAreaCountList;
//		}catch(Exception ex) {
//			System.out.println("Exception is"+ex);
//			return null;
//		}
//		
//	}

	public LinkedHashMap<String, Integer> getCityWiseAreaCount() {
		try {
			map=new LinkedHashMap<String,Integer>();
			this.cityWiseAreaCountList = new ArrayList<Object[]>();
			pst = cn.prepareStatement(
					"select c.cname,count(acj.areaid) from cityareajoin acj inner join citymaster c on acj.cid=c.cid inner join areamaster am on acj.areaid=am.areaid group by c.cname");
			rs = pst.executeQuery();
			while (rs.next()) {

				map.put(rs.getString(1), rs.getInt(2));
			}
			return map;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}

	}
	
	public LinkedHashMap<String,ArrayList<String>> getCityWiseAreas() {
		try {
			this.map1=new LinkedHashMap<String, ArrayList<String>>();
			pst=cn.prepareStatement("select cname from citymaster");
			rs=pst.executeQuery();
			while(rs.next()) {
				String id1=rs.getString(1);
				
				PreparedStatement pst1=cn.prepareStatement("select am.areaname from cityareajoin acj inner join citymaster c on acj.cid=c.cid inner join areamaster am on acj.areaid=am.areaid where c.cname=?");
				pst1.setString(1,id1);
				ResultSet temprs=pst1.executeQuery();
				ArrayList<String> tempAl=new ArrayList<String>();
				while(temprs.next()) {
					tempAl.add(temprs.getString(1));
				}
				this.map1.put(id1,tempAl);
			}
			return this.map1;
		} catch (Exception ex) {
			System.out.println("Exception is" + ex);
			return null;
		}

	}

	public ArrayList<String> getAreaList(int cid) {
		try {
			ArrayList<String> al = new ArrayList<>();
			pst=cn.prepareStatement("select am.areaname from cityareajoin acj inner join citymaster c on acj.cid=c.cid inner join areamaster am on acj.areaid=am.areaid where c.cid=?");
			pst.setInt(1, cid);
			rs=pst.executeQuery();
			while(rs.next()) {
				al.add(rs.getString(1));
			}
			return al;
		}catch(Exception ex) {
			return null;
		}
	}

}

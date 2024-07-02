package client;

import java.sql.SQLException;
import java.util.*;

import model.AmenitiesModel;
import model.AreaMasterModel;
import model.AreaSqFeetModel;
import model.CityMasterModel;
import service.AmenitiesService;
import service.AreaService;
import service.AreaSqService;
import service.CityService;

public class MainClient {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		int choice = 0, aid = 0;
		String sname = null;
		CityMasterModel cmodel = new CityMasterModel();
		CityService cs = new CityService();
		AreaSqService ass = new AreaSqService();
		AreaService as = new AreaService();
		AmenitiesService amserv = new AmenitiesService();
		boolean b = false;
		do {
			System.out.println("1 to add city");
			System.out.println("2 to display all cities");
			System.out.println("3 to add Bulk cities");
			System.out.println("4 to add Area");
			System.out.println("5 Citywise Area Counting");
			System.out.println("6 Citywise AreaList");
			System.out.println("7 Add Square Feet");
			System.out.println("8 to add Amenities");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("Enter City name");
				sname = sc.nextLine();
				cmodel = new CityMasterModel(sname);
				b = cs.isAddCity(cmodel);
				if (b)
					System.out.println("City Added");
				else
					System.out.println("City not Added");
				break;
			case 2:
				List<CityMasterModel> list = cs.getCityList(cmodel);
				for (CityMasterModel m : list) {
					System.out.println(m.getId() + "\t" + m.getName());
				}
				break;
			case 3:
				b = cs.addBulkCities(cmodel);
				if (b) {
					System.out.println("Bulk Cities Added");
				} else {
					System.out.println("Problem has been arised");
				}
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter city name where you want to add area");
				String city = sc.nextLine();
				int cid = cs.getCityId(city);
				System.out.println(cid);
				if (cid != -1) {
					System.out.println("Enter Area Name");
					String aname = sc.next();
					aid = cs.getAreaIDAuto();
					AreaMasterModel am = new AreaMasterModel();
					am.setId(cid);
					am.setArId(aid);
					am.setAreaName(aname);
					b = cs.isAddAr(am);
					if (b) {
						System.out.println("Area added successfully");
					} else {
						System.out.println("Area not added");
					}
				} else {

					System.out.println("User City is not available do you want to add new City");
					String msg = sc.next();
					if (msg.equals("yes")) {
						System.out.println("Enter City name");
						sc.nextLine();
						sname = sc.nextLine();
						cmodel = new CityMasterModel(sname);
						b = cs.isAddCity(cmodel);
						if (b)
							System.out.println("City Added");
						else
							System.out.println("City not Added");
					}
				}
//				if(cid!=0 && cid!=-1) {
//					System.out.println("Enter Area Name");
////					sc.nextLine();
//					String area=sc.nextLine();
//					am.setAreaName(area);
//					b=as.addArea(am,city);
//					if(b)System.out.println("Area Added");
//					else System.out.println("Area not added");
//				}else {
//					System.out.println("City Not added");
//				}

				break;
			case 5:
				LinkedHashMap<String, Integer> map = cs.getCityWiseAreaCount();
				if (map == null) {
					System.out.println("No data present");
				} else {
					Set<Map.Entry<String, Integer>> mset = map.entrySet();
					for (Map.Entry<String, Integer> mset1 : mset) {
						System.out.println(mset1.getKey() + "\t" + mset1.getValue());

					}
				}
				break;
			case 6:

				Map<String, ArrayList<String>> Cwmap = cs.getCityWiseAreas();
				Set<Map.Entry<String, ArrayList<String>>> mset = Cwmap.entrySet();
				for (Map.Entry<String, ArrayList<String>> mset1 : mset) {

					ArrayList<String> tempL = mset1.getValue();
					if (tempL.size() >= 1) {
						System.out.println(mset1.getKey());
						for (String s : tempL) {
							System.out.print(s + "\t");
						}
						System.out.println("\t");
					}
				}

				break;
			case 7:
				System.out.println("Enter Sqfeet size");
				int sqSize = sc.nextInt();
				AreaSqFeetModel asfm = new AreaSqFeetModel(sqSize);
				b = ass.isAddSqFeet(asfm);
				if (b)
					System.out.println("Square feet added successfully....!!");
				else
					System.out.println("Square feet not added");
				break;
			case 8:
				int achoice=0;
				do {
					System.out.println("Enter Amenities");
					sc.nextLine();
					String amenities = sc.nextLine();
					AmenitiesModel ameMod = new AmenitiesModel(amenities);
					b = amserv.isAddAmenities(ameMod);
					if (b)
						System.out.println("Amenities added successfully....!!");
					else
						System.out.println("Amenities not added");
					System.out.println("Press 1 to add another amenities");
					achoice=sc.nextInt();
				}while(achoice==1);
				
				break;
			case 9:
				System.out.println("Enter CityName");
				sc.nextLine();
				String cname=sc.nextLine();
				cid=cs.getCityId(cname);
				if(cid>=0) {
					System.out.println("Choose area in which you want to purchase area");
					ArrayList<String>areas=cs.getCityList(cid);
					if(areas!=null) {
						for(String arl:areas) {
							System.out.println(arl);
						}
					}else {
						System.out.println("No areas present want to add areas?");
					}
				}else {
					System.out.println("No city present");
				}
				break;
			default:
				System.out.println("Into the default mode");
			}

		} while (choice != 10);

	}

}

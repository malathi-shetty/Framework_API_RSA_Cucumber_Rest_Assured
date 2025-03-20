package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.Pojo_Add_Place;
import pojo.Pojo_Location;

public class Pojo_TestDataBuild {
	
	
	public Pojo_Add_Place addPlacePayload(String name, String language, String address)

	{
		Pojo_Add_Place p = new Pojo_Add_Place();
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(address);
		p.setWebsite("http://google.com");
		p.setLanguage(language);

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		p.setTypes(myList);

		Pojo_Location l = new Pojo_Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		
		return p;
	}
	
	public String deletePlacePayload(String place_id)
	{
		return "{\r\n     \"place_id\":\""+place_id+"\"\r\n}";
	}
}

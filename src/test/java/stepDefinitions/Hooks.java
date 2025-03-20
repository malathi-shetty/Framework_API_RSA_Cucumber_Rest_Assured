package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.*;

public class Hooks {
	
	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//write a code that will give place_id
		//Execute this code only when place_id is null
		
		StepDefinition sd = new StepDefinition();
		if(sd.place_id == null) {
		sd.add_place_payload_with("Shetty", "Tulu", "Asia"); // name, language, address
		sd.user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.verify_place_id_created_maps_to_using_get_place_api("Shetty", "getPlaceAPI");
		}
	}

}

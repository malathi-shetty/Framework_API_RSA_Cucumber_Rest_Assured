package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import io.cucumber.java.en.*;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Enum_APIResources;
import resources.Pojo_TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	Pojo_TestDataBuild data = new Pojo_TestDataBuild();
	static String place_id;

	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address)); // given
																										// attached is
																										// the request
																										// to API
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpmethod) {

		// constructor will be called with value of resource which you pass

		// Enum_APIResources resourceAPI = Enum_APIResources.valueOf(deletePlaceAPI);
		Enum_APIResources resourceAPI = Enum_APIResources.valueOf(resource);
		System.out.println("Enum_APIResources: " + resourceAPI.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		if (httpmethod.equalsIgnoreCase("POST")) {
			// response = res.when().post("maps/api/place/ad/json") // negative test case
			// check in logging.txt
			response = res.when().post(resourceAPI.getResource()); // when attached is the request send to Pojo_API

		} else if (httpmethod.equalsIgnoreCase("GET")) {
			response = res.when().get(resourceAPI.getResource());
		}

		// .then().assertThat().spec(resspec).extract().response(); // then attached is
		// the response we get
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
		
		
		assertEquals(getJsonPath(response,keyValue).toString(), ExpectedValue);
	}

	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using_get_place_api(String expectedName, String resource) throws IOException {
		//Request Spec
		
	 place_id =	getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_http_request(resource, "GET") ;
		String actualName =	getJsonPath(response, "name");
	    assertEquals(actualName,expectedName);
	    //  assertEquals(actualName,"abc");//negative test case
	}
	

	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		
		res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
				
				//https://www.freeformatter.com/json-escape.html
	    
	}





}

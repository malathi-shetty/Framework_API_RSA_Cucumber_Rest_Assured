package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	public RequestSpecification requestSpecification() throws IOException
	{
	if(req==null)
	{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		log.println("[" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "] This is a log message");
	//	RestAssured.baseURI = "https://rahulshettyacademy.com/";
		 req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		 return req;
	}
	return req;
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Git Projects\\Framework_API_RSA_Cucumber_Rest_Assured\\src\\test\\java\\resources\\global.properties");
		prop.load(fis);
		//prop.getProperty("baseUrl");
		return prop.getProperty(key);
		 
	}
	
	public String getJsonPath(Response response, String key)
			{
		String resp = response.asPrettyString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
			}

}

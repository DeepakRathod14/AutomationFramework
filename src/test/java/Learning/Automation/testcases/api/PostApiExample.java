package Learning.Automation.testcases.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Learning.Automation.beans.Authentication;
import Learning.Automation.beans.Token;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class PostApiExample {

	private static String token;
	
	@BeforeTest
	public void preCondition() {
		baseURI = "https://restful-booker.herokuapp.com";
		basePath = "/auth";
	}
	
	
	@Test(enabled = false, description = "1rd priority")
	public void postBodyAsFile() {
		//String env = MavenProperty.getProperty("environment");
		String env = "qa";
		File file = new File("src/test/resources/"+env+"/auth.json");
		System.out.println("File Path "+file.getAbsolutePath());
		
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(file) //body(File);
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	@Test(enabled = false, description = "2rd priority")
	public void postBodyAsObjectMap() {
		//String env = MavenProperty.getProperty("environment");
		Map<String, String> map = new HashMap<>();
		map.put("username", "admin");
		map.put("password", "password123");
		
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(map) //body(Object of Map);
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	@Test(enabled = true, description = "2rd priority")
	public void postBodyAsObjectClass() {
		//String env = MavenProperty.getProperty("environment");
		Authentication auth = new Authentication();
		auth.setUsername("admin");
		auth.setPassword("password123");
		
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(auth) //body(Object of Java Class);
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	@Test(enabled = false, description = "3rd priority")
	public void postBodyAsString() {
		String bodyPayload = "{\r\n" + 
				"    \"username\" : \"admin\",\r\n" + 
				"    \"password\" : \"password123\"\r\n" + 
				"}";
		
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(bodyPayload) //body(String);
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	@Test(enabled = false, description = "Less frequent")
	public void postBodyAsByteArray() {
		String bodyPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(bodyPayload.getBytes()) //body(Byte[]);
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	@Test(enabled = false, description = "Less frequent")
	public void postBodyAsInputStream() {
		String bodyPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		InputStream targetStream = new ByteArrayInputStream(bodyPayload.getBytes());
		Response response = given()
			.header("Content-Type", ContentType.JSON)
			.body(targetStream) //body(InputStream);			
			.post();
		
		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : "+token);
	}
	
	
}

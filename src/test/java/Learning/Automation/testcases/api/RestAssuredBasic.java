package Learning.Automation.testcases.api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RestAssuredBasic {

	@Test
	public void example1() {
		System.out.println("Default values ");
		System.out.println(DEFAULT_URI);
		System.out.println(DEFAULT_BODY_ROOT_PATH);
		System.out.println(DEFAULT_PATH);
		System.out.println(DEFAULT_PORT);
		System.out.println(DEFAULT_SESSION_ID_VALUE);
		System.out.println(DEFAULT_URL_ENCODING_ENABLED);
		System.out.println(DEFAULT_AUTH);
		
		baseURI="https://reqres.in";
		basePath="/api";
		
		System.out.println(baseURI);
		System.out.println(basePath);
		
		Response response = given().get("/users"); //https://reqres.in/api/users
		System.out.println(response.asString());
	}
}

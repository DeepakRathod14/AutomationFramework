package Learning.Automation.testcases.api;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static Learning.Automation.testcases.api.PatternExample.*;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetAPIExample {

	@BeforeTest
	public void setup() {
		baseURI="https://reqres.in";
		basePath="/api";
	}

	//@Test(description = "API Methods [ GET, POST, PUT, PATCH, DELETE ] ")
	public void getHeaderExample() {
		Header h1 = new Header("ContetntType", "Application/json");
		Header h2 = new Header("Token","kjfksdjfdksfdskfjsdkfj");
		
		Headers headers = new Headers(h1,h2);
		Map<String, String> map = new HashMap();
		map.put("ContentType", "Application/json");
		map.put("AcceptType", "Application/json");
		map.put("Token", "kdjflaskfjlsfj9erekjrer94jfkdfjdk");
		map.put("uid", "abc@qa.com");
		
		//Object.method1(); object.method2();
		Response response = given()
			//.header("ContentType", "Application/json") // passing individula headers data in line
			//.header(h1) // passing individual header object
			//.header(h2)
			//.headers(headers) //Passing multiple headers in form of headers object
			//.headers(map) // We can pass multiple headers in ofrm of Map object
			.headers("key1", "val1", "key2","val2","key3","val3") // Approch-3 we can pass multiple headers in form of arguments.
			.get("/users");
		
		response.then().log().all(); //sout(response);
		response.then().statusCode(201);
	}
	
	
	//@Test
	public void getExample2() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("page", "2");
		Response res = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.expect()
				.statusCode(200)
				.body("page", Matchers.equalTo(2))
			.with()
			.queryParam("page", "2") //way-2
			.get("/users");
			//.get("/users?page=2")//Way-1
	
		res.then().log().body();
	}
	
	
	@Test
	public void getPathParam() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", 2);
		Response res = given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			//.pathParam("deepak", 2) //way1
			//.pathParams(map)
			
			.get("/users/{page}");//way1
	
		res.then().log().body();
	}
	
	
	//@Test
	public void patternExample() {
		setId(1);
		setName("Testing");
		setAdd("ksjfkds");
		setMobile(9893489324l);
	
		setId(2)
		.setName("xyz")
		.setAdd("askdjfkds")
		.setMobile(21343545l);
		
		System.out.println(getId());
		System.out.println(getName());
		System.out.println(getAdd());
		System.out.println(getMobile());
		System.out.println("Instance : "+(PatternExample.setId(3).equals(PatternExample.setName("fgdfg"))));
	}
		
}

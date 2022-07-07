package Learning.Automation.testcases.api;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import groovyjarjarpicocli.CommandLine.Spec;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SpecificationExample {

	private RequestSpecification spec2;
	
	@BeforeTest
	public void setup() {
		baseURI="https://reqres.in";
		basePath="/api";
		
		requestSpecification = new RequestSpecBuilder()
				.addCookie("Deepak")
				.addHeader("ContentType", "application/json")
				.log(LogDetail.BODY)
				.setAccept(ContentType.JSON)
				.build();
		spec2 = new RequestSpecBuilder()
				.addHeader("ContentType", "application/json")
				.setBody("testinf")
				.build();
		
		responseSpecification = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectResponseTime(Matchers.lessThanOrEqualTo(2l), TimeUnit.SECONDS)				
				.expectHeader("Content-Type", "application/json; charset=utf-8")
				.expectStatusLine(Matchers.containsString("OK"))	
				.build();
		
	}
	
	@Test
	public void getExample() {
		given(requestSpecification,responseSpecification)
				.get("/users?page=2");
		
	}
	
	@Test
	public void postExample() {
		given(requestSpecification,responseSpecification)
				.get("/users/2");		
//		
//		rs.then()
//		.statusCode(200)
//		.time(Matchers.lessThanOrEqualTo(2l), TimeUnit.SECONDS)
//		.header("AcceptType", "application/json")
//		.statusLine(Matchers.containsString("Ok"));
	}
	
	@Test
	public void putExample() {
		
	}
	
	@Test
	public void deleteExample() {
		
	}
}

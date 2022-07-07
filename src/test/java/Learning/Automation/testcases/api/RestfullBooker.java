package Learning.Automation.testcases.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Learning.Automation.beans.guest.Bookingdates;
import Learning.Automation.beans.guest.GuestInfo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RestfullBooker {

	private static String token;
	private static int bookingID;
	
	@BeforeTest
	public void setup() {
		baseURI = "https://restful-booker.herokuapp.com";
		basePath = "/auth";
	}

	@Test(priority = 1, enabled = true)
	public void getToken() {
		String bodyPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
		Response response = given() //url/auth
				.header("Content-Type", ContentType.JSON)
				.body(bodyPayload) // body(String);				
				.post();			

		response.then().log().all();
		response.then().statusCode(200);
		token = response.getBody().jsonPath().getString("token");
		System.out.println("Extracted Token : " + token);
	}
	
	@Test(priority = 2, enabled = false)
	public void getBookingIDs() {
		basePath="/booking"; //url/booking
		Response allBookings = given()
				.get();
		allBookings.then().log().all(); // It will get all booking IDs
		bookingID = allBookings.then().extract().jsonPath().getInt("[0].bookingid");
		System.out.println("Booking ID : "+bookingID);
	}
	
	@Test(priority = 3, dependsOnMethods = {"getBookingIDs"}, enabled = false)
	public void getBookingWithID() {
		Response res = given() //url/booking/bookingID
				.pathParam("bookingID", bookingID)
				.get("{bookingID}");
		res.then().log().all();
		GuestInfo guest = res.as(GuestInfo.class);
		
		System.out.println("FirstName : "+guest.getFirstname());
		System.out.println("LastName : "+guest.getLastname());
		System.out.println("Total Price : "+guest.getTotalprice());
		System.out.println("Deposite : "+guest.getDepositpaid());
		System.out.println("Booking-CheckIn Date : "+guest.getBookingdates().getCheckin());
		System.out.println("Booking-CheckOut Date : "+guest.getBookingdates().getCheckout());
		System.out.println("Additional Needs : "+guest.getAdditionalneeds());
		
	}
	
	@Test(priority = 4)
	public void createBooking() {
		GuestInfo guest = new GuestInfo()
				.setFirstname("Deepk")
				.setLastname("Rathod")
				.setDepositpaid(true)
				.setTotalprice(15000)
				.setBookingdates(new Bookingdates()
						.setCheckin("2022-12-10")
						.setCheckout("2022-12-11"))
				.setAdditionalneeds("Breakfast");
		
		basePath="/booking";
		Response res = given() //url/booking
				.header("Content-Type", "application/json")				
				.body(guest)
				.post();
		
		
		System.out.println("New Booking Generated");
		System.out.println(res.asPrettyString());
		res.then().statusCode(200);
		bookingID = res.then().extract().jsonPath().getInt("bookingid");
		System.out.println("Booking ID : "+bookingID);
	}
	
	@Test(priority = 5)
	public void updateBooking() {
		System.out.println("================Before Update==================");
		getBookingWithID();
		
		GuestInfo guest = new GuestInfo()
				.setFirstname("Anuj")
				.setLastname("Shah")
				.setDepositpaid(true)
				.setTotalprice(15000)
				.setBookingdates(new Bookingdates()
						.setCheckin("2022-12-10")
						.setCheckout("2022-12-11"))
				.setAdditionalneeds("Lunch");
		
		Response res = given() //url/booking/bookingID
				.header("Content-Type", "application/json")		
				.header("Accept", "application/json")		
				.header("Cookie", "token="+token)		
				.body(guest)
				.pathParam("id", bookingID)
				.put("{id}");
		
		
		System.out.println("New Booking Generated");
		System.out.println(res.asPrettyString());
		res.then().statusCode(200);
		System.out.println("================After Update==================");
		getBookingWithID();
	}
	
	@Test(priority = 6)
	public void deleteBooking() {
		given() //url/booking/bookingID
			.header("Content-Type", "application/json")		
			.header("Cookie", "token="+token)		
			.pathParam("id", bookingID)
			.delete("{id}")
		.then()
			.statusCode(201);
	
		System.out.println("=========== AFTER DELETE ==========");
		getBookingWithID(); //404
	}
	
}

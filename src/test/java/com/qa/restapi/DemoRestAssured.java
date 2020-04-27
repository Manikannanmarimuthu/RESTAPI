package com.qa.restapi;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DemoRestAssured {

	@Test
	public void verifyRestPost() {

		// given - all input details
		// when - Submit the API -resource,http method
		// Then - validate the response

		RestAssured.baseURI = "https://reqres.in";

		String response = given().log().all().header("Content-Type", "application/json").body(payload.body())

				.when().post("/api/users")

				.then().assertThat().statusCode(201).body("name", equalTo("Raghu")).extract().response().asString();

		System.out.println("Response is " + response);

	}
}
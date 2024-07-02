package com.ust.apimoduleassessment.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.apimoduleassessment.endpoints.ObjectEndpoints;
import com.ust.apimoduleassessment.payloads.ObjectModel;
import com.ust.apimoduleassessment.utilities.ExtentReportsListener;

import com.ust.apimoduleassessment.endpoints.Routes;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Listeners(ExtentReportsListener.class)
public class ObjectTest {

	@BeforeClass
	public void setup() {
		RestAssured.useRelaxedHTTPSValidation();
	}

	@Test(priority = 1)
		public void getsingleObject() {
			
			Response response = ObjectEndpoints.getSingleObject(7);
			response.then().assertThat().statusCode(200);
	}
	@Test(priority = 2)
	public void getObjectbyID() {

		Response response = ObjectEndpoints.getObjectbyID();
		response.then().assertThat().statusCode(200);

	}

	@Test(priority = 3)
	public void getallObjects() {
		Response response = ObjectEndpoints.getObject();
		response.then().assertThat().statusCode(200);
		response.then().assertThat()
				.body(matchesJsonSchema(new File(System.getProperty("user.dir") + "schemas/schema.json")));
	}

	@Test(priority = 4)
	public void createObject() {
		ObjectModel om = new ObjectModel(7,"pixel", 2007, 1000000, "Intel Core i9", "1 TB");
		Response response = ObjectEndpoints.createObject(om);
		response.then().assertThat().statusCode(200);
	}

	@Test(priority = 5)
	public void update() {
		ObjectModel om = new ObjectModel(7,"pixel", 2007, 1000000, "Intel Core i9", "1 TB");
		Response response = ObjectEndpoints.updateObject(7,om);
		response.then().assertThat().statusCode(200);

	}

	@Test(priority = 6)
	public void delete() {
		Response response = ObjectEndpoints.deleteObject(6);
		response.then().assertThat().statusCode(200);
	}
	
	@Test(priority = 7)
	public void schemaValidation() {
		RestAssured.given().baseUri(Routes.baseurl)
		.when().get().then().assertThat()
		.body(matchesJsonSchema(new File("Schema/getobject.json")));
	}

}

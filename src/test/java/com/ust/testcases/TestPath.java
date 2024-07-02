package com.ust.testcases;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.endpoints.UserEndPoints;
import com.ust.payloads.UserModel;
import com.ust.utils.ExtentReportsListener;

import io.restassured.RestAssured;
import io.restassured.response.Response;


@Listeners(ExtentReportsListener.class)
public class TestPath {

	public UserModel payload;

	@BeforeClass
	public void setUp() {
		payload = new UserModel(1,"Tiger Nixon",320800,61,"");
	}

	@Test(priority = 5)
	public void getEmployee() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndPoints.getEmployee(0);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 1)
	public void getEmployeeID() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndPoints.getEmployeeId(payload.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 2)
	public void testPostUser(String name, long salary, int age, long id) {
		RestAssured.useRelaxedHTTPSValidation();
		UserModel payload = new UserModel();
		payload.setEmployee_name(name);
		payload.setEmployee_salary(salary);
		payload.setEmployee_age(age);
		payload.setId(id);
		Response response = UserEndPoints.postReq(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
	}

	@Test(priority = 3)
	public void putReqTest(String name, long salary, int age) {
		RestAssured.useRelaxedHTTPSValidation();
		payload.setEmployee_name(name);
		payload.setEmployee_salary(salary);
		payload.setEmployee_age(age);
		UserModel payload2 = new UserModel();
		Response response = UserEndPoints.putReq(payload.getId(), payload2);
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void deleteReqTest() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndPoints.delReq(payload.getId());
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}


	@Test(priority = 0)
	public void schemavalidation() {
		RestAssured.useRelaxedHTTPSValidation();
		Response response = UserEndPoints.getEmployeeId(payload.getId());
		response.then().assertThat().body(matchesJsonSchema(
				new File(System.getProperty("user.dir")+"\\src\\test\\resources\\schema.json")));
	}
}

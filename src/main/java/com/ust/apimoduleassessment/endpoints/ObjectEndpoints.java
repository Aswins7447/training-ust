package com.ust.apimoduleassessment.endpoints;

import com.ust.apimoduleassessment.payloads.ObjectModel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ObjectEndpoints {
	

		public static Response getObject() {
			Response response = RestAssured.given().headers(

					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(null).contentType("application/json").accept(ContentType.JSON).when().get();
			return response;
		}

		public static Response getObjectbyID() {
			Response response = RestAssured.given().headers(

					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(Routes.getobjectbyid).contentType("application/json")
					.accept(ContentType.JSON).when().get();
			return response;
		}

		public static Response getSingleObject(long id) {
			Response response = RestAssured.given().headers(
					
					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(Routes.getsingleobject).pathParam("id", id).contentType("application/json")
					.accept(ContentType.JSON).when().get();
			return response;
		}
		
		public static Response createObject(ObjectModel payload) {
			Response response = RestAssured.given().headers(

					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(null).contentType("application/json").accept(ContentType.JSON).body(payload)
					.when().post();
			return response;
		}

		public static Response updateObject(long id, ObjectModel payload) {

			Response response = RestAssured.given().headers(

					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(Routes.updateobject).pathParam("id", id).contentType("application/json").accept(ContentType.JSON)
					.body(payload).when().put();
			return response;
		}
		
		public static Response patchObject(long id, ObjectModel payload) {
			
			Response response = RestAssured.given().headers(
					
					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(Routes.updateobject).pathParam("id", id).contentType("application/json").accept(ContentType.JSON)
					.body(payload).when().patch();
			return response;
		}

		public static Response deleteObject(long id) {
			Response response = RestAssured.given().headers(

					"Content-Type", ContentType.JSON, "Accept", ContentType.JSON).baseUri(Routes.baseurl)
					.basePath(Routes.deleteobject).pathParam("id", id).contentType("application/json").accept(ContentType.JSON)
					.when().delete();
			return response;
		}

	}



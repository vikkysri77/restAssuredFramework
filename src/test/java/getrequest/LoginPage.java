package getrequest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class LoginPage {
	Response resp;
	String e_Token;
	@Test
	public void postLogin() {
		
//		Set up base URI
		
		RestAssured.baseURI= "https://qa-ms.revature.com";
		String str1 = "{" + 
				"\"password\" : \"Pass123$\"," + 
				"\"timeZone\" : \"America/New_York\"," + 
				"\"userName\" : \"shuta001@yopmail.com\"\r\n" + 
				"}";
		
		given().
		contentType(ContentType.JSON).
		body(str1).
		when().
		post("/security/admin/login").
		then().assertThat().
		statusCode(200).and().contentType(ContentType.JSON).and().
		body("data.userName", equalTo("shuta001@yopmail.com")).
		extract().response();
		
		String responseString = resp.asString();
//		System.out.println(responseString);
		
		JsonPath jsonPath = new JsonPath(responseString);
		e_Token = jsonPath.get("data.encryptedLoginToken");
		System.out.println(e_Token);
		
		}
	
//	public void getAllQuestions() {
//		RestAssured.baseURI= "https://qa-ms.revature.com";
//		given().
//		contentType(ContentType.JSON).
//		header("encryptedToken", e_Token);
//		
//		
//		
//	}

	
}

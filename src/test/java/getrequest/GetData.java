package getrequest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.google.gson.JsonObject;

public class GetData {
	
	/*
	 * @Test public void testResponseCode() { Response resp = get(
	 * "https://68c6dw3mmf.execute-api.us-west-1.amazonaws.com/qa2/security/status/info"
	 * ); int scode = resp.getStatusCode(); System.out.println("Status code is"+
	 * scode); Assert.assertEquals(scode, 200); }
	 * 
	 * @Test public void getbody() { Response resp = get(
	 * "https://68c6dw3mmf.execute-api.us-west-1.amazonaws.com/qa2/security/status/info"
	 * ); String sbody = resp.asString(); System.out.println("Response body is"+
	 * sbody); System.out.println("Response time is " + resp.getTime()); }
	 */
	
	@Test
	public void adminLogin() {
		
		  RestAssured.baseURI = "https://qa-ms.revature.com";
	        RequestSpecification httpRequest = RestAssured.given();
	        httpRequest.header("Content-Type", "application/json");
	        
	        
	        // Create new JSON Object
	        JsonObject loginCredentials = new JsonObject();
	        loginCredentials.addProperty("userName", "shusya005@yopmail.com");
	        loginCredentials.addProperty("password", "Pass123$");
	        loginCredentials.addProperty("timeZone","America/New_York");
	        httpRequest.body(loginCredentials.toString());
	        Response response = httpRequest.post("/security/admin/login");        
	        int scode1 = response.getStatusCode();
	        System.out.println("Status code is"+ scode1);
			Assert.assertEquals(scode1, 200);
			
	}


}

package Assessment_Api.Assessment_Api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestOne {
	
	
	String Validtoken="D2ylDkcYWXfQVT8my4hbyUD0dUl7Pt1j1FepMXN6mHjB0UIqwje00iCfLjj2Pcy65zaFjQ44pwzcvDjl7DN1ZJUEvx4K04Dc79rqqzPOpq2jNJp9pG4sJbIIbnjHP0CZR1pFpHnLEvYGSvfrkzytdvprXXE";


	
	

	@Test
	public void Testcaseone()
	{

		Map <String,Object> map = new HashMap< String,Object>();

		JSONObject request=new JSONObject();
		request.put("Username","Test");
		request.put("Password","Test@123");
		System.out.println(request.toJSONString());

		RequestSpecification request1=given().relaxedHTTPSValidation();

		request1.header("content-Type","application/json");
		request1.header("Authorization",Validtoken);

		Response response=request1.body(request.toJSONString()).post("https://ec2-13-58-105-161.us-east-2.compute.amazonaws.com/rest/v1/locations");
		response.prettyPrint();
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 401);
	}



	@Test
	public void TestcaseTwo()

	{
		RequestSpecification request1=given();
		request1.header("content-Type","application/json");
		request1.header("Authorization",Validtoken);

		Response response=request1.get("https://ec2-13-58-105-161.us-east-2.compute.amazonaws.com/rest/v1/locations");
		response.prettyPrint();
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 401);

	}

	

}

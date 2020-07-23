package com.libraryassignmentofserializationanddserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class DeleteidRunner {
	public static String DELETE_ID="/Library/DeleteBook.php";
	
  @Test
	public void test() {
		RestAssured.baseURI="http://216.10.245.166";
		
		Deleteidresponse resp=new Deleteidresponse();
		resp.setID("8812818");
	
	  given().log()
	    .all().header("content-type","application/json")
		.when()
		.body(resp)
		.post(DELETE_ID)
		.then().log().all()
		.assertThat().statusCode(200);
	
	//  System.out.println("ID "+resp.getID());
	   
    
    


}	

}

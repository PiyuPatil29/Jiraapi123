package com.libraryassignmentofserializationanddserialization;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getlibraryserialanddserialization.Get;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Runner {

	public static final String ADD_RECORD="/Library/Addbook.php";
	public static final String GET_AUTHOR_NAME = "/Library/GetBook.php?AuthorName=Joy";
	public static final String GET_BOOK_ID="/Library/GetBook.php?ID=11";
	public static final String DELETE_ID="/Library/DeleteBook.php";
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		RestAssured.baseURI="http://216.10.245.166";
		//(SERIALIZATION)
		AddBook book=new AddBook();
		book.setName("Java and Selenium  rest Assured and basics history");
		book.setIsbn("CUCUM");
		book.setAisle("203");
		book.setAuthor("Joyeece");
		
		//(DSERIALIZATION)
		
		Librarygetdata getdata=new Librarygetdata();
		
	    String bookresponse=	given().log().all()
		.header("Content-Type","application/json")
		.body(book)
		//.expect()
		//.defaultParser(Parser.JSON)
		.when()
		.post(ADD_RECORD)
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.extract().asString();
	    
	    ObjectMapper mapper=new ObjectMapper();
	    mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
	    mapper.readValue(bookresponse,Librarygetdata.class);
	    
	    System.out.println("Msg :"+getdata.getMsg());
	    System.out.println("Id: "+getdata.getId());
	    
//GET_AUTHORNAME (DSERIALIZATION)
	    
		             Librarygetdata[] array=given().log()
			        .all().header("content-type","application/json")
			    	.expect()
			    	.defaultParser(Parser.JSON)
			    	.when()
			    	.post(GET_AUTHOR_NAME)
			        .then().log().all()
			    	.assertThat()
			    	.statusCode(200)
			    	.extract()
			    	.as(Librarygetdata[].class);
		             
		       
			    	 for(Librarygetdata getdata1 :array) { 		 
			    			        
			        System.out.println(getdata1.getBook_name());
			        System.out.println(getdata1.getAisle());
			    	System.out.println(getdata1.getIsbn());
			    	
//GET_ID (DSERIALIZATION)
			    	
			    	Idresponse[] array1=given().log()
					        .all().header("content-type","application/json")
					    	.expect()
					    	.defaultParser(Parser.JSON)
					    	.when()
					    	.post(GET_BOOK_ID)
					        .then().log().all()
					    	.assertThat()
					    	.statusCode(200)
					    	.extract()
					    	.as(Idresponse[].class);
					    		             
					    	 for(Idresponse resp :array1) {
					    			        
					        System.out.println(resp.getBook_name());
					        System.out.println(resp.getIsbn());
					        System.out.println(resp.getAisle());
					        System.out.println(resp.getAuthor());
					    	
//DELETE_ID SERIALIZATION IS DONE GETTING ERROR IN DSERIALIZATION
					        Idresponse del=new Idresponse();
					        del.setID("oppo22337");
					        
					        given().log()
					        .all().header("content-type","application/json")
					    	.when()
					    	.body(del)
					    	.post(DELETE_ID)
					    	.then().log().all()
					    	.assertThat().statusCode(200);
					        
					        

			    	 }
			   }	
	}
}


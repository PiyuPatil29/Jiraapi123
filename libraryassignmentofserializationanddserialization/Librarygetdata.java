package com.libraryassignmentofserializationanddserialization;

public class Librarygetdata {
	private String Msg;
	private String Id;

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
}

//ForAuthorname Response in postman 
	
public String book_name;
public String isbn;
public String aisle;

public String getBook_name() {
	return book_name;
}

public void setBookname(String book_name) {
	this.book_name = book_name;
}

public String getIsbn() {
	return isbn;
}

public void setIsbn(String isbn) {
	this.isbn = isbn;
}

public String getAisle() {
	return aisle;
}

public void setAisle(String aisle) {
	this.aisle = aisle;
}

}
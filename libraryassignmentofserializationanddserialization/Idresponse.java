package com.libraryassignmentofserializationanddserialization;

public class Idresponse {

	// GET RESPONSE FROM POSTMAN TO SET GETTER AND SETTER METHOD ON IT

	private String book_name;
	private String isbn;
	private String aisle;
	private String author;

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
        //DELETE_ID SERIALIZATION
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	
}

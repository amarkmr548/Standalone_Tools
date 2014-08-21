package com.java.tools;

import java.util.ArrayList;

public class Book {
	private static String isbn="0025";
	private static String name="harry";
	
	private static ArrayList<String> line = new ArrayList<String>();
	
	static{
		line.add("here is the first line");
		line.add("here is the second line");
	}

	public static String getIsbn() {
		return isbn;
	}

	public static void setIsbn(String isbn) {
		Book.isbn = isbn;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Book.name = name;
	}

	public static ArrayList<String> getLine() {
		return line;
	}

	public static void setLine(ArrayList<String> line) {
		Book.line = line;
	}
	
	
	
}

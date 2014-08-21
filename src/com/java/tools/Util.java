package com.java.tools;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {
	public int avg;
	public int getAvg() {
		return avg;
	}
	
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public static void main(String[] args) {
		while(true){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy hh:mm");
		
		
		String formattedDate = sdf.format(date);
		
		System.out.println(formattedDate);
		System.console();
		}
		
		
	}
}

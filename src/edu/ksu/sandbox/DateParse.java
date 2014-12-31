package edu.ksu.sandbox;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParse {

	public static void main(String[] args) throws ParseException {

		String target = "December 30, 2014";
		DateFormat df = new SimpleDateFormat("MMMMM d, yyyy");
		Date result =  df.parse(target);
		System.out.println(result.toString());
	}

}

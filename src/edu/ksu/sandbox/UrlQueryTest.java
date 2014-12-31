package edu.ksu.sandbox;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlQueryTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://speeches.byu.edu/?act=sortByYear&ByYear=1949");
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}

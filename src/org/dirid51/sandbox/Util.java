package org.dirid51.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;

public class Util {
	public static String getHTMLPage(URL url) throws IOException, URISyntaxException {
//		System.out.println("Reading page at: " + url.toString());
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        StringBuilder result = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
	        result.append(inputLine);
        }
        in.close();
        return result.toString();
	}
	
	public static String getHTMLPage(String url) throws IOException, URISyntaxException {
		return getHTMLPage(new URL(url));
	}
}

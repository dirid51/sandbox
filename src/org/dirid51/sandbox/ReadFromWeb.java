package org.dirid51.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class ReadFromWeb {

	public static void main(String[] args) {
		try {
	        URL url = URI.create("https://www.lds.org/general-conference/1992/04/memories-of-yesterday-counsel-for-today?lang=eng").toURL();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuilder html = new StringBuilder();
	        while (reader.ready()) {
	        	html.append(reader.readLine());
	        }
	        System.out.println(html.toString());
        } catch (IOException e) {
	        e.printStackTrace();
        }
	}

}

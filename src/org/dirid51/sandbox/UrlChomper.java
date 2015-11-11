package org.dirid51.sandbox;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class UrlChomper {

	public static void main(String[] args) {
		try {
	        URL url = URI.create("https://www.lds.org/general-conference/1992/04/the-pure-love-of-god?lang=eng").toURL();
	        String urlString = url.toExternalForm();
	        String[] urlPieces = urlString.split("\\/");
	        StringBuilder result = new StringBuilder();
	        result.append(urlPieces[urlPieces.length - 3] + "-");
	        result.append(urlPieces[urlPieces.length - 2] + "-");
	        result.append(urlPieces[urlPieces.length - 1].split("\\?")[0]);
	        System.out.println(result);
        } catch (MalformedURLException e) {
	        e.printStackTrace();
        }
	}

}

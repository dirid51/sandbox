package org.dirid51.sandbox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CountryCounting {
	
	private static final String WORLD_HERITAGE_LIST_URL = "http://whc.unesco.org/en/list/";

	public static void main(String[] args) {
		Document doc;
		Elements countries = null;
        try {
	        doc = Jsoup.parse(Util.getHTMLPage(new URL(WORLD_HERITAGE_LIST_URL)));
	        countries = doc.select("div#acc h4 a");
        } catch (IOException | URISyntaxException e1) {
	        e1.printStackTrace();
        }
        if (countries != null) {
	        System.out.println("Countries: " + countries.size());
	        for (Element c : countries) {
	        	System.out.println(c.text());
	        }
        } else {
        	System.out.println("Nada!");
        }
	}

}

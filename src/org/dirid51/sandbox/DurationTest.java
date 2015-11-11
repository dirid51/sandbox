package org.dirid51.sandbox;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DurationTest {

	private static final String WORLD_HERITAGE_LIST_URL = "http://whc.unesco.org/en/list/";

	public static void main(String[] args) {
		Instant begin = Instant.ofEpochMilli(System.currentTimeMillis());
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
		Duration elapsed = Duration.between(begin, Instant.ofEpochMilli(System.currentTimeMillis()));
		System.out.println("Elapsed Time: H" + elapsed.toHours() + " M" + elapsed.toMinutes() + " S" + elapsed.getSeconds() + " N" + elapsed.getNano() + "/" + elapsed.toNanos() + " M" + elapsed.toMillis());
		System.out.println("Elapsed: " + elapsed.getSeconds() + "." + (elapsed.toMillis() - (elapsed.getSeconds() * 1000)) + " seconds");
	}

}

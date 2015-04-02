package org.dirid51.sandbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class UrlOpenStream {

	public static void main(String[] args) throws IOException {
		URL oracle = new URL("http://speeches.byu.edu/?act=sortByYear&ByYear=1949");
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()));

		String inputLine;
		StringBuilder result = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
//			System.out.println(inputLine);
			result.append(inputLine);
		}
		in.close();
		
		Document doc = Jsoup.parse(result.toString());
		Elements links = doc.select("a[href^=index.php]");
		for (Element e : links) {
			System.out.println(e.attr("href"));
			System.out.println(e.parent().parent().parent().html());
			System.out.println();
		}
	}

}

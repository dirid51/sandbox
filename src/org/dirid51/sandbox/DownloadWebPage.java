package org.dirid51.sandbox;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Files;

public class DownloadWebPage {

	public static void main(String[] args) {
		try {
			
			URL website = URI.create("https://www.lds.org/general-conference/print/1992/04/memories-of-yesterday-counsel-for-today?lang=eng").toURL();
            URLConnection con = website.openConnection();
            con.addRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            con.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.90 Safari/537.36");

            Files.copy(con.getInputStream(), FileSystems.getDefault().getPath("C:/Users/randallbooth/Desktop/" + DownloadWebPage.getTalkName(website) + ".html"));
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	public static String getTalkName(URL url) {
		String urlString = url.toExternalForm();
		String[] urlPieces = urlString.split("\\/");
		return urlPieces[urlPieces.length - 1].split("\\?")[0];
	}

}

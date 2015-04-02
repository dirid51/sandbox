package org.dirid51.sandbox;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class ImageEncoder64 {

	public static void main(String[] args) {
		try {
			Files.deleteIfExists(Paths.get("C:\\Users\\randallbooth\\Desktop\\base64images.html"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		List<byte[]> images64 = new ArrayList<byte[]>();
		for (int i = 1; i < 10; i++) {
			try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Screensaver Photos\\" + Integer.toString(i) + "_iceland.jpg")))) {
				byte[] imageBytes = new byte[0];
				for (byte[] ba = new byte[bis.available()]; bis.read(ba) != -1;) {
					byte[] baTmp = new byte[imageBytes.length + ba.length];
					System.arraycopy(imageBytes, 0, baTmp, 0, imageBytes.length);
					System.arraycopy(ba, 0, baTmp, imageBytes.length, ba.length);
					imageBytes = baTmp;
				}
				images64.add(imageBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE html><head><title>Iceland - Testing Base64 Images</title></head>\n");
		html.append("<body><h1>Iceland!</h1>\n");
		for (byte[] img : images64) {
			html.append("<p><img src='data:image/png;base64," + DatatypeConverter.printBase64Binary(img) + "'></p>\n");
		}
		html.append("</body></html>");

		try {
			Files.write(Files.createFile(Paths.get("C:\\Users\\randallbooth\\Desktop\\base64images.html")), html.toString().getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

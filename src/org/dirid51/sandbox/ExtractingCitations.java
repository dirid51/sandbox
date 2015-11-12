package org.dirid51.sandbox;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ExtractingCitations {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("\\(.+?\\)");
		System.out.println("Checking complete documents...");
		Path dir = Paths.get("C:\\Users\\randallbooth\\Downloads\\GC Text");
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.html")) {
//			Set<byte[]> exclude = new HashSet<>(Arrays.asList("ASL".getBytes(StandardCharsets.UTF_8), "Updated".getBytes(StandardCharsets.UTF_8), "Avañe'?".getBytes(StandardCharsets.UTF_8)));
			String[] exclude = {"Updated"};
			int count = 0;
			for (Path entry : stream) {
				String source = new String(Files.readAllBytes(entry), StandardCharsets.UTF_8);
				Document doc = Jsoup.parse(source);
				Matcher m = pattern.matcher(doc.text());
				System.out.println(entry.toAbsolutePath());
				while (m.find()) {
					StringBuilder groupBuilder = new StringBuilder(m.group());
					String group = groupBuilder.substring(1, groupBuilder.length() - 1);
					if (group.length() > 8 && !StringUtils.startsWithAny(group, exclude)) {
						System.out.println(Integer.toString(++count) + "\t\t" + group);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

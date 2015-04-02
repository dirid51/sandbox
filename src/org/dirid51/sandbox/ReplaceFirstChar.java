package org.dirid51.sandbox;

import java.util.Arrays;

public class ReplaceFirstChar {
	
	private static final String CATEGORY = "long-exposure-test";

	public static void main(String[] args) {
		System.out.println(CATEGORY.replaceFirst(Character.toString(CATEGORY.charAt(0)), Character.toString(CATEGORY.charAt(0)).toUpperCase())); //Doesn't work when hyphens are used as space replacements
		System.out.println(CATEGORY.substring(0,1).toUpperCase() + CATEGORY.substring(1)); //Same as above
		System.out.println(String.join(" ", Arrays.asList(CATEGORY.split("[- ]")))); //Great hyphen-to-space replacement, but fails in capitalizing.
		System.out.println(Arrays.asList(CATEGORY.split("[- ]"))
						.stream()
						.map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
						.reduce((t, u) -> (new StringBuilder(t + " " + u)).toString())
						.get());
	}

}

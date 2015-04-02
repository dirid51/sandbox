package org.dirid51.sandbox;

public class StringFormatting {

	public static void main(String[] args) {
		String test = String.format("http://www.amazon.com/gp/registry/wishlist/%s/ref=cm_wl_sortbar_o_page_%d?ie=UTF8&page=%d", "3BE3H0GH6X6YM", 1, 1);
		System.out.println(test);
	}

}

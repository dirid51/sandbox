package org.dirid51.sandbox;

public class RemoveSpecials {

	public static void main(String[] args) {
		RemoveSpecials rs = new RemoveSpecials();
		System.out.println(rs.removeSpecials("What Do You Envision in Life?"));

	}
	
	public String removeSpecials(String input) {
		StringBuilder result = new StringBuilder();
		
		for (Character c : input.toCharArray()) {
			if (Character.isDigit(c) || Character.isLetter(c) || Character.isSpaceChar(c)) {
				result.append(c);
			}
		}
		
		return result.toString();
	}

}

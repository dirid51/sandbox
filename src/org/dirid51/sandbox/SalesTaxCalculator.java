package org.dirid51.sandbox;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalesTaxCalculator {

	public static void main(String[] args) {
		if (args.length == 2) {
			BigDecimal totalSales = new BigDecimal(args[0]).setScale(10, RoundingMode.CEILING);
			System.out.println("totalSales: " + totalSales.toPlainString());
			BigDecimal taxPercentage = new BigDecimal(args[1]).movePointLeft(2);
			System.out.println("taxPercentage: " + taxPercentage.toPlainString());
			BigDecimal onePlusTaxPercent = BigDecimal.ONE.add(taxPercentage);
			System.out.println("onePlusTaxPercent: " + onePlusTaxPercent.toPlainString());
			BigDecimal earned = totalSales.divide(onePlusTaxPercent, RoundingMode.CEILING);
			System.out.println("earned: " + earned.toPlainString());
			BigDecimal salesTax = totalSales.subtract(earned).setScale(2, RoundingMode.CEILING);
			System.out.println("salesTax: " + salesTax.toPlainString());
		} else {
			System.out.println("Invalid usage.");
			System.out.println();
			System.out.println("Correct usage:");
			System.out.println("java SalesTaxCalculator <total sales> <sales tax percentage>");
			System.out.println("Example:\t\tjava SalesTaxCalculator 520.75 9.1");
			System.out.println();
		}
	}

}

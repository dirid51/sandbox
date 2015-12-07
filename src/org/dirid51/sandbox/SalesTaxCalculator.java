package org.dirid51.sandbox;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class SalesTaxCalculator {

	public static void main(String[] args) {
		if (args.length == 3 && StringUtils.isNumeric(args[1]) && StringUtils.isNumeric(args[2])) {
			BigDecimal totalSales = new BigDecimal(args[1]);
			BigDecimal salesTaxPercentage = new BigDecimal(1 + (Float.valueOf(args[2]) / 100.0));
			BigDecimal earned = totalSales.divide(salesTaxPercentage);
			BigDecimal salesTaxDollars = totalSales.subtract(earned);
			System.out.println("\tReceived:\t\t" + totalSales.toPlainString());
			System.out.println("\tKeeping:\t\t" + earned.toPlainString());
			System.out.println("\tSales Tax:\t\t" + salesTaxDollars.toPlainString());
		} else {
			System.out.println("Invalid usage.");
			System.out.println();
			System.out.println("Correct usage:");
			System.out.println("java SalesTaxCalculator <total sales> <sales tax percentage>");
			System.out.println();
		}
	}

}

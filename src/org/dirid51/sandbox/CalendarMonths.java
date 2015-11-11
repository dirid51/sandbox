package org.dirid51.sandbox;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarMonths {

	public static void main(String[] args) {
		Calendar cal = GregorianCalendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH);
		System.out.println("Current month: " + currentMonth);
		System.out.println("April: " + Calendar.APRIL);
		System.out.println("October: " + Calendar.OCTOBER);
		if (currentMonth < Calendar.APRIL || currentMonth > Calendar.OCTOBER) {
			System.out.println("Last was October");
		} else {
			System.out.println("Last was April");
		}
	}

}

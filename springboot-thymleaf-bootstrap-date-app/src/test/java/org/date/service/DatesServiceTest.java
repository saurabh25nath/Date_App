package org.date.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.date.service.DateService;
import org.junit.Test;

public class DatesServiceTest {

	@Test
	public void testCalculateDateInterval_SameDays() {
		DateService service = new DateService();
		Calendar startDate = Calendar.getInstance();
		startDate.set(2019, 01, 01);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2019, 01, 01);
		assertEquals(0, service.calculateTwoDateDifference(startDate.getTime(), endDate.getTime()));
	}

	@Test
	public void testCalculateDateInterval_SequentialDays() {
		DateService service = new DateService();
		Calendar startDate = Calendar.getInstance();
		startDate.set(2019, 01, 01);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2019, 01, 02);
		assertEquals(1, service.calculateTwoDateDifference(startDate.getTime(), endDate.getTime()));
	}

	@Test
	public void testCalculateDateInterval_NonLeapYear() {
		DateService service = new DateService();
		Calendar startDate = Calendar.getInstance();
		startDate.set(2019, 01, 01);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2020, 01, 01);
		assertEquals(365, service.calculateTwoDateDifference(startDate.getTime(), endDate.getTime()));
	}

	@Test
	public void testCalculateDateInterval_LeapYear() {
		DateService service = new DateService();
		Calendar startDate = Calendar.getInstance();
		startDate.set(2020, 01, 01);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2021, 01, 01);
		assertEquals(366, service.calculateTwoDateDifference(startDate.getTime(), endDate.getTime()));
	}

	@Test
	public void testCalculateDateInterval_EndDayBeforeStart() {
		DateService service = new DateService();
		Calendar startDate = Calendar.getInstance();
		startDate.set(2025, 01, 01);
		Calendar endDate = Calendar.getInstance();
		endDate.set(2021, 01, 01);
		assertTrue("End before start", service.calculateTwoDateDifference(startDate.getTime(), endDate.getTime()) < 0);
	}
}

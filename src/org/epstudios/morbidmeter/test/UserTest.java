package org.epstudios.morbidmeter.test;

import java.util.Calendar;

import junit.framework.TestCase;

import org.epstudios.morbidmeter.User;

public class UserTest extends TestCase {

	public UserTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testUser() {
		User user = new User("default", Calendar.getInstance(), 80.0);
	}

	public void testDeathDay() {
		Calendar bd = Calendar.getInstance();
		bd.set(Calendar.YEAR, 1950);
		bd.set(Calendar.MONTH, 1);
		bd.set(Calendar.DAY_OF_MONTH, 1);
		User user = new User("default", bd, 80.0);
		int deathYear = user.deathDay().get(Calendar.YEAR);
		assertEquals(2030, deathYear);
	}

	public void testPercentAlive() {
		Calendar bd = Calendar.getInstance();
		bd.set(Calendar.YEAR, 1950);
		bd.set(Calendar.MONTH, 1);
		bd.set(Calendar.DAY_OF_MONTH, 1);
		User user = new User("default", bd, 80.0);
		Calendar testDate = Calendar.getInstance();
		testDate.set(Calendar.YEAR, 1990);
		testDate.set(Calendar.MONTH, 1);
		testDate.set(Calendar.DAY_OF_MONTH, 1);
		assertEquals(0.5, user.percentAlive(testDate), 0.01);
	}

	public void testIsSane() {
		double longevity = 80.1;
		Calendar bd = Calendar.getInstance();
		bd.set(Calendar.YEAR, 1950);
		bd.set(Calendar.MONTH, 1);
		bd.set(Calendar.DAY_OF_MONTH, 1);
		User user = new User("", bd, longevity);
		assertEquals(true, user.isSane());
		longevity = -1;
		user = new User("", bd, longevity);
		assertEquals(false, user.isSane());
	}

}

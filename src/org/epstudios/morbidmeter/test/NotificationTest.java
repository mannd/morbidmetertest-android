package org.epstudios.morbidmeter.test;

import junit.framework.TestCase;

import org.epstudios.morbidmeter.MorbidMeter;

public class NotificationTest extends TestCase {

	public NotificationTest(String name) {
		super(name);
	}

	public void testIsMilestone() {
		assert (MorbidMeter.isEvenHour("Jan 4, 2012 5:00:03 AM 414 msec"));
		assert (!MorbidMeter.isEvenHour("Jan 4, 2012 5:01:03 AM 414 msec"));
		assert (!MorbidMeter.isEvenHour("Jan 4, 2012 5:01:00 AM 414 msec"));
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

}

package org.epstudios.morbidmeter.test;

import junit.framework.TestCase;

import org.epstudios.morbidmeter.TimeScale;

public class TimeScaleTest extends TestCase {
	public void testTimeScaleDuration() {
		TimeScale ts = new TimeScale("test", 0, 100, "");
		assertEquals(100, ts.duration());
	}

	public void testProportionalTime() {
		TimeScale ts = new TimeScale("", 0, 100, "");
		assertEquals(50.0, ts.proportionalTime(.5));
		assertEquals(0.0, ts.proportionalTime(0));
		assertEquals(100.0, ts.proportionalTime(1));
	}

	public void testReverseProportionalTime() {
		TimeScale ts = new TimeScale("", 500, 600, "");
		assertEquals(550.0, ts.reverseProportionaltime(.5));
		assertEquals(500.0, ts.reverseProportionaltime(1));
		assertEquals(600.0, ts.reverseProportionaltime(0));
	}
}

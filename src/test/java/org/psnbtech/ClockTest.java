package org.psnbtech;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.psnbtech.Clock;


class ClockTest {

	@Test
	void testClockClick() {
		// Initialize with 60 cycles per second
		Clock clock = new Clock(60.0f);
		assertNotNull(clock, "Clock instance should not be Null");
		assertFalse(clock.isPaused(), "Clock should not be paused on initialization");
	}

}

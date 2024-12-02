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
	
	@Test
	void testClockReset() {
		// 60 cycles per second
		Clock clock =  new Clock(60.0f);
		
		// Change state 
		clock.setPaused(true);
		
		// Reset state
		clock.reset();
		
		assertFalse(clock.isPaused(), "Clock should not be paused after reset");
		assertFalse(clock.peekElapsedCycle(), "No cycles should have elapsed after reset");
	}
	
	@Test 
	void testClockUpdate()throws InterruptedException{
		// 2 cycles per second (599 ms per cycle)
		Clock clock = new Clock(2.0f);
		
		// Wait more than 1 cycle
		Thread.sleep(600);
		clock.update();
		assertTrue(clock.hasElapsedCycle(), "At least one cycle should have elapsed");
	}
	
	@Test
	void testClockPause(){
		Clock clock = new Clock(60);
		clock.setPaused(true);
		assertTrue(clock.isPaused(), "Clock should be paused");
		clock.setPaused(false);
		assertFalse(clock.isPaused(), "Clock should not be paused after unpausing");
	}

}

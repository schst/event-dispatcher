package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CountCaughtEventsListener;

public class ResetTestCase extends TestCase {

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.reset()'
	 */
	public void testReset() throws Exception {

		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener);
		dispatcher.addListener("onTest", listener);
		dispatcher.reset();
		
		dispatcher.triggerEvent("onTest");		
		TestCase.assertEquals(0, listener.countCaughtEvents());
	}
}
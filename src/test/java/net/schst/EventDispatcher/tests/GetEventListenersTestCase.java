package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CountCaughtEventsListener;

public class GetEventListenersTestCase extends TestCase {

	private EventDispatcher dispatcher;
	
	public void setUp() throws Exception {
		super.setUp();
		this.dispatcher = EventDispatcher.getInstance();
	}
	
	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.getEventListeners(String)'
	 */
	public void testGetEventListeners() throws Exception {
		this.dispatcher.addListener("onTest", new CountCaughtEventsListener());		
		TestCase.assertNotNull(this.dispatcher.getEventListeners("onTest"));
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.getGlobalEventListeners()'
	 */
	public void testGetGlobalEventListeners() {
	}
}
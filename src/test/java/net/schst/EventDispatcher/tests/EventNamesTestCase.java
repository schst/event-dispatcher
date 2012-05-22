package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CountCaughtEventsListener;

public class EventNamesTestCase extends TestCase {

	private EventDispatcher dispatcher;
	
	public void setUp() throws Exception {
		super.setUp();
		this.dispatcher = EventDispatcher.getInstance();
	}
	
	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.getRegisteredEventNames()'
	 */
	public void testGetRegisteredEventNames() throws Exception {
		this.dispatcher.addListener("onTest", new CountCaughtEventsListener());
		this.dispatcher.addListener("onFoo", new CountCaughtEventsListener());
		
		String[] eventNames = dispatcher.getRegisteredEventNames();
		String[] expected = {"onTest", "onFoo"};
		
		TestCase.assertEquals(expected[0], eventNames[0]);
		TestCase.assertEquals(expected[1], eventNames[1]);
	}
}
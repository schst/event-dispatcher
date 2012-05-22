package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CountCaughtEventsListener;

public class AutoRemoveTestCase extends TestCase {

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addListener(String, EventListener, boolean)'
	 */
	public void testAddListenerStringEventListenerBoolean() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		
		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener, true);
		dispatcher.triggerEvent("onTest");
		dispatcher.triggerEvent("onTest");
		dispatcher.triggerEvent("onTest");
		
		TestCase.assertEquals(1, listener.countCaughtEvents());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addGlobalListener(EventListener, boolean)'
	 */
	public void testAddGlobalListenerEventListenerBoolean() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addGlobalListener(listener, true);
		dispatcher.triggerEvent("onFoo");
		dispatcher.triggerEvent("onBar");

		TestCase.assertEquals(1, listener.countCaughtEvents());
	}
}
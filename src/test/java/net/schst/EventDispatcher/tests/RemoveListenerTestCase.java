package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CountCaughtEventsListener;

public class RemoveListenerTestCase extends TestCase {

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeEventListener(String, String)'
	 */
	public void testRemoveEventListenerStringString() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener);
		dispatcher.removeEventListener("onTest", listener.getClass().getName());
		
		dispatcher.triggerEvent("onTest");		
		TestCase.assertEquals(0, listener.countCaughtEvents());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeEventListener(String, EventListener)'
	 */
	public void testRemoveEventListenerStringEventListener() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener);
		dispatcher.removeEventListener("onTest", listener);
		
		dispatcher.triggerEvent("onTest");		
		TestCase.assertEquals(0, listener.countCaughtEvents());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(EventListener)'
	 */
	public void testRemoveGlobalEventListenerEventListener() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addGlobalListener(listener);
		dispatcher.removeGlobalEventListener(listener);
		
		dispatcher.triggerEvent("onTest");
		dispatcher.triggerEvent("onFoo");
		TestCase.assertEquals(0, listener.countCaughtEvents());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(String)'
	 */
	public void testRemoveGlobalEventListenerString() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addGlobalListener(listener);
		dispatcher.removeGlobalEventListener(listener.getClass().getName());
		
		dispatcher.triggerEvent("onTest");
		dispatcher.triggerEvent("onFoo");
		TestCase.assertEquals(0, listener.countCaughtEvents());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(String)'
	 */
	public void testRemoveUnknownEventListenerEventListener() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		CountCaughtEventsListener listener2 = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener);

		TestCase.assertNull(dispatcher.removeEventListener("onFoo", listener));
		TestCase.assertNull(dispatcher.removeEventListener("onTest", listener2));
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(String)'
	 */
	public void testRemoveUnknownEventListenerString() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addListener("onTest", listener);

		TestCase.assertNull(dispatcher.removeEventListener("onFoo", listener.getClass().getName()));
		TestCase.assertNull(dispatcher.removeEventListener("onTest", "invalid.class.name"));
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(EventListener)'
	 */
	public void testRemoveUnknownGlobalEventListenerEventListener() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		CountCaughtEventsListener listener2 = new CountCaughtEventsListener();
		dispatcher.addGlobalListener(listener);
		TestCase.assertNull(dispatcher.removeGlobalEventListener(listener2));
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.removeGlobalEventListener(String)'
	 */
	public void testRemoveUnknownGlobalEventListenerString() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();

		CountCaughtEventsListener listener = new CountCaughtEventsListener();
		dispatcher.addGlobalListener(listener);
		TestCase.assertNull(dispatcher.removeGlobalEventListener("invalid.class.name"));
	}
}
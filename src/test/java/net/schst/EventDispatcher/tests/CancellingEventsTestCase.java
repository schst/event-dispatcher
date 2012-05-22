package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * Testcase for cancelling events
 *
 * @author Stephan Schmidt <me@schst.net>
 */
public class CancellingEventsTestCase extends TestCase {

	private EventDispatcher dispatcher;
	
	public void setUp() throws Exception {
		super.setUp();
		this.dispatcher = EventDispatcher.getInstance();
	}

	/**
	 * Test cancelling a simple event without context
	 * or user information
	 * @throws Exception 
	 */
	public void testSimpleEvent() throws Exception {
		this.dispatcher.addListener("onTest", new CancellingEventListener());
		Event event = this.dispatcher.triggerEvent("onTest");
		TestCase.assertTrue(event.isCancelled());
	}
	
	/**
	 * Test cancelling a simple event without context
	 * or user information
	 * @throws Exception 
	 */
	public void testContextEvent() throws Exception {
		this.dispatcher.addListener("onTest", new CancellingEventListener());
		Event event = this.dispatcher.triggerEvent("onTest", false, new Object());
		TestCase.assertTrue(event.isCancelled());
	}
	
	/**
	 * Test cancelling a simple event without context
	 * or user information
	 * @throws Exception 
	 */
	public void testContextAndUserInfoEvent() throws Exception {
		this.dispatcher.addListener("onTest", new CancellingEventListener());
		Event event = this.dispatcher.triggerEvent("onTest", false, new Object(), new Object());
		TestCase.assertTrue(event.isCancelled());
	}
	
	/**
	 * Simple listener, that cancels any event.
	 *
	 * @author Stephan Schmidt <me@schst.net>
	 */
	class CancellingEventListener implements EventListener {

		public void handleEvent(Event e) throws Exception {
			e.cancel();
		}
	}
}
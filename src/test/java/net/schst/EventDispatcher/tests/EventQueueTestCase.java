package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.CaptureEventListener;

public class EventQueueTestCase extends TestCase {

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(Event, boolean)'
	 */
	public void testTriggerEventObject() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		
		Event triggered = new Event("onTest");
		dispatcher.triggerEvent(triggered, true);
		
		// With local listener
		CaptureEventListener listener = new CaptureEventListener();
		dispatcher.addListener("onTest", listener);		
		Event captured = listener.getLastCapturedEvent();		
		TestCase.assertSame(triggered, captured);
		
		// With global listener
		CaptureEventListener listener2 = new CaptureEventListener();
		dispatcher.addGlobalListener(listener2);
		Event capturedByGlobal = listener2.getLastCapturedEvent();		
		TestCase.assertSame(triggered, capturedByGlobal);		

		// Add a listener for a different event
		CaptureEventListener listener3 = new CaptureEventListener();
		dispatcher.addListener("onFoo", listener3);		
		Event nullEvent = listener3.getLastCapturedEvent();		
		TestCase.assertEquals(null, nullEvent);
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(String, boolean)'
	 */
	public void testTriggerEventString() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		
		Event triggered = dispatcher.triggerEvent("onTest", true);
		
		// With local listener
		CaptureEventListener listener = new CaptureEventListener();
		dispatcher.addListener("onTest", listener);		
		Event captured = listener.getLastCapturedEvent();
		TestCase.assertSame(triggered, captured);
		
		// With global listener
		CaptureEventListener listener2 = new CaptureEventListener();
		dispatcher.addGlobalListener(listener2);
		Event capturedByGlobal = listener2.getLastCapturedEvent();		
		TestCase.assertSame(triggered, capturedByGlobal);
		
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(Event, boolean)'
	 */
	public void testTriggerEventQueueFlag() throws Exception {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		
		Event e;
		
		e = dispatcher.triggerEvent("onTest", true);
		TestCase.assertTrue(e.isQueued());

		e = dispatcher.triggerEvent("onTest", false);
		TestCase.assertFalse(e.isQueued());

		e = dispatcher.triggerEvent("onTest");
		TestCase.assertFalse(e.isQueued());
	}
}
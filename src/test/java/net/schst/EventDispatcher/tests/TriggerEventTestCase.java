package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventDispatcher;

/**
 * Test triggering events
 *
 * @author Stephan Schmidt <me@schst.net>
 */
public class TriggerEventTestCase extends TestCase {

	private EventDispatcher dispatcher;
	
	public void setUp() throws Exception {
		super.setUp();
		this.dispatcher = EventDispatcher.getInstance();
	}
	
	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(Event)'
	 */
	public void testTriggerEventEvent() throws Exception {
		String context = new String("context");
		String userInfo = new String("userInfo");
		Event event = new Event("onTest", context, userInfo);
		Event returned = this.dispatcher.triggerEvent(event);
		TestCase.assertEquals(event, returned);
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(Event, boolean)'
	 */
	public void testTriggerEventEventBoolean() throws Exception {
		String context = new String("context");
		String userInfo = new String("userInfo");
		Event event = new Event("onTest", context, userInfo);
		Event returned = this.dispatcher.triggerEvent(event, false);
		TestCase.assertSame(event, returned);
		Event returnedQueued = this.dispatcher.triggerEvent(event, true);
		TestCase.assertEquals(event, returnedQueued);
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(String)'
	 */
	public void testTriggerEventString() throws Exception {
		Event returned = this.dispatcher.triggerEvent("onTest");
		TestCase.assertEquals("onTest", returned.getName());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(String, boolean)'
	 */
	public void testTriggerEventStringBoolean() throws Exception {
		Event returned = this.dispatcher.triggerEvent("onTest", false);
		TestCase.assertEquals("onTest", returned.getName());
		Event returnedQueued = this.dispatcher.triggerEvent("onTest", true);
		TestCase.assertEquals("onTest", returnedQueued.getName());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(String, boolean, Object)'
	 */
	public void testTriggerEventStringBooleanObject() throws Exception {
		String context = new String("context");
		Event returned = this.dispatcher.triggerEvent("onTest", false, context);
		TestCase.assertSame(context, returned.getContext());
		Event returnedQueued = this.dispatcher.triggerEvent("onTest", true, context);
		TestCase.assertSame(context, returnedQueued.getContext());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.triggerEvent(String, boolean, Object, Object)'
	 */
	public void testTriggerEventStringBooleanObjectObject() throws Exception {
		String context = new String("context");
		String userInfo = new String("userInfo");
		Event returned = this.dispatcher.triggerEvent("onTest", false, context, userInfo);
		TestCase.assertSame(context, returned.getContext());
		TestCase.assertSame(userInfo, returned.getUserInfo());
		Event returnedQueued = this.dispatcher.triggerEvent("onTest", true, context, userInfo);
		TestCase.assertSame(userInfo, returnedQueued.getUserInfo());
	}
}
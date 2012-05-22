package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.tests.helpers.DummyEventListener;

public class AddListenersTestCase extends TestCase {

	private EventDispatcher dispatcher;
	
	public void setUp() throws Exception {
		super.setUp();
		this.dispatcher = EventDispatcher.getInstance();
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addListener(String, EventListener)'
	 */
	public void testAddListenerStringEventListener() throws Exception {
		this.dispatcher.addListener("onTest", new DummyEventListener());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addListener(String, EventListener, boolean)'
	 */
	public void testAddListenerStringEventListenerBoolean() throws Exception {
		this.dispatcher.addListener("onTest", new DummyEventListener(), true);
		this.dispatcher.addListener("onTest", new DummyEventListener(), false);
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addGlobalListener(EventListener)'
	 */
	public void testAddGlobalListenerEventListener() throws Exception {
		this.dispatcher.addGlobalListener(new DummyEventListener());
	}

	/*
	 * Test method for 'net.schst.EventDispatcher.EventDispatcher.addGlobalListener(EventListener, boolean)'
	 */
	public void testAddGlobalListenerEventListenerBoolean() throws Exception {
		this.dispatcher.addGlobalListener(new DummyEventListener(), true);
		this.dispatcher.addGlobalListener(new DummyEventListener(), false);
	}
}
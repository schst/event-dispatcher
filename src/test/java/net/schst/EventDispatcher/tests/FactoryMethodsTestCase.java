package net.schst.EventDispatcher.tests;

import junit.framework.TestCase;
import net.schst.EventDispatcher.EventDispatcher;

public class FactoryMethodsTestCase extends TestCase {

	/**
	 * Test, whether getInstance() always returns the same instance
	 */
	public void testGetInstance() {
		EventDispatcher dispatcher = EventDispatcher.getInstance();
		EventDispatcher dispatcher2 = EventDispatcher.getInstance();
		TestCase.assertTrue(dispatcher instanceof EventDispatcher);
		TestCase.assertSame(dispatcher, dispatcher2);
	}

	/**
	 * Test, whether getInstance(String) always returns the same instance,
	 * when the same String is passed.
	 */
	public void testGetInstanceString() {
		EventDispatcher dispatcher = EventDispatcher.getInstance("foo");
		EventDispatcher dispatcher2 = EventDispatcher.getInstance("foo");
		EventDispatcher dispatcher3 = EventDispatcher.getInstance("bar");
		TestCase.assertSame(dispatcher, dispatcher2);
		TestCase.assertNotSame(dispatcher, dispatcher3);
		TestCase.assertNotSame(dispatcher2, dispatcher3);
	}

	/**
	 * Test, whether getDetachedInstance() always returns different dispatchers
	 */
	public void testGetDetachedInstance() {
		EventDispatcher dispatcher = EventDispatcher.getDetachedInstance();
		EventDispatcher dispatcher2 = EventDispatcher.getDetachedInstance();
		TestCase.assertNotSame(dispatcher, dispatcher2);
	}

	/**
	 * Test detaching instances
	 */
	public void testDetachDispatcher() {
		EventDispatcher dispatcher = EventDispatcher.getInstance("foo");
		EventDispatcher dispatcher2 = EventDispatcher.getInstance("foo");
		EventDispatcher.detachDispatcher("foo");
		EventDispatcher dispatcher3 = EventDispatcher.getInstance("foo");

		TestCase.assertSame(dispatcher, dispatcher2);
		TestCase.assertNotSame(dispatcher, dispatcher3);
		TestCase.assertNotSame(dispatcher2, dispatcher3);
	}

	/**
	 * Test detaching instances
	 */
	public void testDetachDispatcherReturnValue() {
		EventDispatcher.getInstance("exists");
		
		boolean result = EventDispatcher.detachDispatcher("exists");
		TestCase.assertSame(true, result);

		boolean result2 = EventDispatcher.detachDispatcher("invalid");
		TestCase.assertSame(false, result2);
	}

	/**
	 * Test whether instances exist after they have been created
	 */
	public void testDispatcherExists() {
		@SuppressWarnings("unused")
		EventDispatcher dispatcher = EventDispatcher.getInstance("foo");
		TestCase.assertTrue(EventDispatcher.dispatcherExists("foo"));
		TestCase.assertFalse(EventDispatcher.dispatcherExists("tomato"));
	}
}
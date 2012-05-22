package net.schst.EventDispatcher.tests.helpers;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

public class CountCaughtEventsListener implements EventListener {

	private int caughtEvents = 0;
	
	public void handleEvent(Event e) throws Exception {
		this.caughtEvents++;
	}

	public int countCaughtEvents() {
		return this.caughtEvents;
	}
}
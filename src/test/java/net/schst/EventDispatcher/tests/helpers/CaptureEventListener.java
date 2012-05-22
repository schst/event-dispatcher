package net.schst.EventDispatcher.tests.helpers;

import java.util.ArrayList;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

public class CaptureEventListener implements EventListener {

	private ArrayList<Event> events = new ArrayList<Event>();
	
	public void handleEvent(Event e) throws Exception {
		this.events.add(e);
	}

	public ArrayList<Event> getCapturedEvents() {
		return this.events;
	}
	
	public Event getLastCapturedEvent() {
		if (this.events.size() == 0) {
			return null;
		}
		return this.events.get(this.events.size()-1);
	}
}

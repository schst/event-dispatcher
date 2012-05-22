package net.schst.EventDispatcher.Examples;

import java.util.Iterator;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;
import net.schst.EventDispatcher.EventListenerCollection;
import net.schst.EventDispatcher.EventListenerContainer;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class ExampleIntrospect {

    public static void main(String[] args) throws Exception {
        EventListener echo1 = new DebugHandler();
        EventListener echo2 = new DebugHandler();
        EventListener echo3 = new DebugHandler();

        EventDispatcher disp = EventDispatcher.getInstance();
        disp.addListener("onLogin", echo1);
        disp.addListener("onLogin", echo2);
        disp.addListener("onLogout", echo3);
        disp.addListener("onFoo", echo1);
        
        String eventNames[] = disp.getRegisteredEventNames();
        for (String eventName : eventNames) {
            System.out.println("Event: " + eventName);
            EventListenerCollection listeners = disp.getEventListeners(eventName);
            for (Iterator iterator = listeners.iterator(); iterator.hasNext();) {
                EventListenerContainer container = (EventListenerContainer) iterator.next();
                System.out.println("        - " + container.getListener().getClass());
            }
        }
    }
}
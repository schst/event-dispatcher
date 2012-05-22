package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class EchoHandler implements EventListener {

    public void handleEvent(Event e) throws Exception {
        Customer cus = (Customer)e.getContext();
        System.out.println("Event handled: " + e.getName() + "("+cus.getName()+")");
    }

}

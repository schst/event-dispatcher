package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class BlackListCheck implements EventListener {

    public void handleEvent(Event e) throws Exception {
        Customer temp = (Customer)e.getContext();
        if (temp.getMandant() == 1) {
            e.cancel();
        }
    }

}

package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class DebugHandler implements EventListener{

    private String name = "No-Name";

    public DebugHandler() {
    }
    
    public DebugHandler(String name) {
        this.name = name;
    }
    
    /**
     * Handle the event
     */
    public void handleEvent(Event e) throws Exception {
        System.out.println("Event caught by '" + this.name + "'");
        System.out.println("Event-name    : " + e.getName());
        System.out.println("Event-context : " + e.getContext());
        System.out.println("in queue      : " + e.isQueued());
        System.out.println();
    }
    
   /**
    * Get the name of the handler
    * 
    * @return
    */
    public String getName() {
        return this.name;
    }
    
}
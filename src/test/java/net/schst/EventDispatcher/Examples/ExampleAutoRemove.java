package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class ExampleAutoRemove {

    public static void main(String[] args) throws Exception {
        EventDispatcher disp = EventDispatcher.getInstance();

        EventListener one = new DebugHandler("one");
        disp.addListener("onLogin", one);
        
        // This listener is set to autoremove and will be
        // removed after it has handled the first event
        EventListener two = new DebugHandler("two");
        disp.addListener("onLogin", two, true);

        EventListener three = new DebugHandler("three");
        disp.addListener("onLogin", three);

        // This global listener is set to autoremove and will be
        // removed after it has handled the first event
        EventListener glob = new DebugHandler("global");
        disp.addGlobalListener(glob, true);
        
        disp.triggerEvent("onLogin");
        
        System.out.println("Trigger a second event");
        System.out.println("----------------------");
        System.out.println();
        
        disp.triggerEvent("onLogin");
    }
}

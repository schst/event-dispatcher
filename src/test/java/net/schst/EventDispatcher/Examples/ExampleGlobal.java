package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * Example that shows how to use global event
 * listeners
 * 
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class ExampleGlobal {

    public static void main(String[] args) throws Exception {
        EventDispatcher disp = EventDispatcher.getInstance();

        EventListener glob = new DebugHandler("global");
        disp.addGlobalListener(glob);
        EventListener loc = new DebugHandler("local");
        disp.addListener("onLogin", loc);
        
        disp.triggerEvent("onLogin");
        disp.triggerEvent("onLogout");
    }
}

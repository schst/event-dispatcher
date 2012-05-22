package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * Example that shows, how to remove event listeners
 * 
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class ExampleRemove {

    public static void main(String[] args) throws Exception {
        EventDispatcher disp = EventDispatcher.getInstance();

        EventListener one = new DebugHandler("one");
        disp.addListener("onLogin", one);
        EventListener two = new DebugHandler("two");
        disp.addListener("onLogin", two);

        EventListener three = new DebugHandler("three");
        disp.addGlobalListener(three);
        EventListener four = new DebugHandler("four");
        disp.addGlobalListener(four);
        EventListener five = new EchoHandler();
        disp.addListener("onLogin", five);
        
        EventListener removed = disp.removeEventListener("onLogin", one);
        if (removed != null) {
            System.out.println("The event listener has succesfully been removed.");
        }

        removed = disp.removeGlobalEventListener(four);
        if (removed != null) {
            System.out.println("The global event listener has succesfully been removed.");
        }
        
        removed = disp.removeEventListener("onLogin", "net.schst.EventDispatcher.Examples.EchoHandler");
        if (removed != null) {
            System.out.println("The event listener has succesfully been removed by supplying the classname.");
        }

        Customer schst = new Customer(14, "Stephan Schmidt");        
        disp.triggerEvent("onLogin", false, schst);
    }
}

package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class ExampleQueue {

    public static void main(String[] args) throws Exception {
        Customer cus1 = new Customer(1, "Stephan Schmidt");
        cus1.login();
        
        EventListener echo = new DebugHandler();
        EventDispatcher disp = EventDispatcher.getInstance();
        disp.addListener("onLogin", echo);
        
        Customer cus2 = new Customer(2, "Andreas Foerch");
        cus2.login();
    }
}

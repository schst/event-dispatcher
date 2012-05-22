package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class Example2 {
    public static void main(String[] args) throws Exception {
        
        Customer cus1 = new Customer(1, "Stephan Schmidt");
        
        EventListener listener = (EventListener)new CallbackListener(cus1, "observe");
        EventDispatcher disp = EventDispatcher.getInstance();
        disp.addListener("onLogin", listener);
        
        cus1.login();
        
        Customer cus2 = new Customer(2, "Andreas Foerch");
        cus2.login();
    }
}
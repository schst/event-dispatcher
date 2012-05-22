package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.EventDispatcher;
import net.schst.EventDispatcher.EventListener;

/**
 * This is a very simple example that shows how to register
 * an event listener to the dispatcher. 
 * 
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class Example1 {
    public static void main(String[] args) throws Exception {
        EventListener echo = new EchoHandler();
        EventDispatcher disp = EventDispatcher.getInstance();
        disp.addListener("onLogin", echo);
        
        Customer cus1 = new Customer(1, "Stephan Schmidt");
        cus1.login();
        
        Customer cus2 = new Customer(2, "Andreas Foerch");
        cus2.login();
    }
}
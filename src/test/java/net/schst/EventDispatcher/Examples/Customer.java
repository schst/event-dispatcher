package net.schst.EventDispatcher.Examples;

import net.schst.EventDispatcher.*;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class Customer {
    private int mandant = 0;
    private String name = null;
    private EventDispatcher disp = null;
    
    public Customer(int mandant, String name) {
        this.mandant = mandant;
        this.name    = name;
        this.disp    = EventDispatcher.getInstance();
    }
    
    public int getMandant() {
        return this.mandant;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean login() throws Exception {
        Event e = (Event)this.disp.triggerEvent("onLogin", true, this);
        if (e.isCancelled()) {
            System.out.println("User " + this.getName() + " is not allowed to login.");
            return false;
        }
        return true;
    }
    
    public void observe(Customer c) {
        System.out.println("observe called and customer " + c.getName() + " passed.");
    }
}

package net.schst.EventDispatcher.Examples;

import java.lang.reflect.Method;

import net.schst.EventDispatcher.Event;
import net.schst.EventDispatcher.EventListener;

/**
 * Proxy Event Listener that is able to forward an event
 * to any method of a class that is able to handle the event.
 * 
 * There are two ways to instantiate this class:
 * - Pass a full qualified classname and a method name
 * - Pass an object and a method name
 * 
 * The method has to be implemented in one of two ways:
 * - It has to accept an instance of net.schst.EventDispatcher.Event as
 *   its sole argument
 * - It has to accept the context of the event as its sole argument
 * 
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public class CallbackListener implements EventListener {
    
    private String className  = null;
    private String methodName = null;
    private Object instance   = null;
    
   /**
    * Create a new callback listener that automatically creates
    * a new instance of the class that will be notified
    * 
    * @param className
    * @param methodName
    */
    public CallbackListener(String className, String methodName) {
        this.className  = className;
        this.methodName = methodName;
    }

    /**
     * Create a new callback listener that uses an existing object
     * as the reciever of the event
     * 
     * @param className
     * @param methodName
     */
    public CallbackListener(Object obj, String methodName) {
        this.instance   = obj;
        this.methodName = methodName;
    }
    
   /**
    * Handle the event
    */
    public void handleEvent(Event event) throws Exception {
        Class cl;
        Method me;
        if (this.instance == null) {
            try {
                cl = Class.forName(this.className);
                this.instance = cl.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                // TODO handle the error
                throw new RuntimeException("error getting the instance"); 
            }
        } else {
            cl = this.instance.getClass();
        }
        
        Class paramTypes[] = {event.getClass()};
        try {
            me = cl.getMethod(this.methodName, paramTypes);
            Object params[] = {event};
            me.invoke(this.instance, params);
        } catch (Throwable e) {
            paramTypes[0] = event.getContext().getClass();
            try {
                me = cl.getMethod(this.methodName, paramTypes);
                Object params[] = {event.getContext()};
                me.invoke(this.instance, params);
            } catch (Throwable t){
                // TODO handle the error
                throw new RuntimeException("error getting the method");
            }
        }       
    }
}
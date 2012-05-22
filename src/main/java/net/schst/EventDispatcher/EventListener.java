package net.schst.EventDispatcher;

/**
 * @author Stephan Schmidt <stephan.schmidt@schlund.de>
 */
public interface EventListener {
    public void handleEvent(Event e) throws Exception;
}

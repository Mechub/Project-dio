package strategy;

import events.Event;

public interface EventNotificationStrategy {
    void notifyObservers(Event event);
}

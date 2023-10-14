package strategy;

import observer.EventNotifier;
import observer.Observer;
import events.Event;

public class DefaultEventNotificationStrategy implements EventNotificationStrategy {
    @Override
    public void notifyObservers(Event event) {
        EventNotifier notifier = EventNotifier.getInstance();
        for (Observer observer : notifier.getObservers()) {
            observer.update(event.getType());
        }
    }
}

package facade;

import observer.EventNotifier;
import strategy.EventNotificationStrategy;
import observer.Observer;
import events.Event;
import strategy.DefaultEventNotificationStrategy;

public class EventNotificationFacade {
    private EventNotifier notifier;
    private EventNotificationStrategy notificationStrategy;

    public EventNotificationFacade() {
        notifier = EventNotifier.getInstance();
        notificationStrategy = new DefaultEventNotificationStrategy();
    }

    public void subscribe(Observer observer) {
        notifier.subscribe(observer);
    }

    public void notify(Event event) {
        notificationStrategy.notifyObservers(event);
    }
}
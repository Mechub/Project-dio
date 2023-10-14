package observer;

import java.util.ArrayList;
import java.util.List;

public class EventNotifier {
    private List<Observer> observers = new ArrayList<>();
    private static EventNotifier instance;

    private EventNotifier() {
    }

    public static EventNotifier getInstance() {
        if (instance == null) {
            instance = new EventNotifier();
        }
        return instance;
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
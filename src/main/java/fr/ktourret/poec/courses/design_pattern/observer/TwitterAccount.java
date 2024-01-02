package fr.ktourret.poec.courses.design_pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TwitterAccount {

    private List<Observer> observers = new ArrayList<>();
    private List<String> feeds = new ArrayList<>();

    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    public void unregisterObserver(Observer o) {
        this.observers.remove(o);
    }

    public void publishedFeed(String content) {
        this.feeds.add(content);
        notifyObservers(content);
    }

    public void notifyObservers(String content) {
        for(Iterator<Observer> it = this.observers.iterator(); it.hasNext();) {
            it.next().myNotify(content);
        }
    }

}

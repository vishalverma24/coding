package org.example.lld.observerPattern.observable;

import org.example.lld.observerPattern.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStockCount(Integer newStockUpdated);

    public int getStockCount();


}

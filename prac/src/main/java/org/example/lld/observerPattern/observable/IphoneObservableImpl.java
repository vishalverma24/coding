package org.example.lld.observerPattern.observable;

import org.example.lld.observerPattern.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable {

    List<NotificationAlertObserver> observerList = new ArrayList<>();
    Integer stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(Integer newStockUpdated) {
        if(stockCount==0){
            notifySubscribers();
        }
        stockCount = stockCount + newStockUpdated;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}

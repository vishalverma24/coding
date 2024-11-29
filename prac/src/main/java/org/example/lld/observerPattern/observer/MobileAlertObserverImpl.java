package org.example.lld.observerPattern.observer;

import org.example.lld.observerPattern.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{
    StockObservable observable;
    String userName;

    public MobileAlertObserverImpl(StockObservable observable, String userName){
        this.observable=observable;
        this.userName=userName;
    }
    @Override
    public void update() {
        sendNotification(userName,"stock available now");
    }

    private void sendNotification(String emailId, String message) {
        System.out.println(message+" -> mail sent to : "+userName);
    }
}

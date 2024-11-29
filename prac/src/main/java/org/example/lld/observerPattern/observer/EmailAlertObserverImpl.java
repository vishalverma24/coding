package org.example.lld.observerPattern.observer;

import org.example.lld.observerPattern.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    StockObservable observable;
    String emailId;

    public EmailAlertObserverImpl(StockObservable observable, String emailId){
        this.observable=observable;
        this.emailId=emailId;
    }
    @Override
    public void update() {
        sendEmail(emailId,"stock available now");
    }

    private void sendEmail(String emailId, String message) {
        System.out.println(message+" -> mail sent to : "+emailId);
    }
}

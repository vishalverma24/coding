package org.example.lld.observerPattern;

import org.example.lld.observerPattern.observable.IphoneObservableImpl;
import org.example.lld.observerPattern.observable.StockObservable;
import org.example.lld.observerPattern.observer.EmailAlertObserverImpl;
import org.example.lld.observerPattern.observer.MobileAlertObserverImpl;
import org.example.lld.observerPattern.observer.NotificationAlertObserver;

public class Store {
    public  static  void main(String[] args){
        StockObservable iphoneObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl(iphoneObservable, "abc@gmail.com");
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl(iphoneObservable,"Vishal_Username");

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);

        iphoneObservable.setStockCount(5);
    }
}

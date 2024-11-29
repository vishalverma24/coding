package org.example.lldQ.sipScheduler;

import java.time.LocalDateTime;

public class OrderPuncher {

    private SIPManager sipManager;

    public OrderPuncher(SIPManager sipManager) {
        this.sipManager=sipManager;
    }

    public void punchOrders(LocalDateTime currentDate) {

        for(SIP sip : sipManager.getSIPS()){
            if(sip.isDueToday(currentDate)){
                sip.updateNextPunchDate();
                System.out.println("Order Punched for " + sip.getFundName() + " with amount " + sip.getAmount());
            }
        }
    }
}

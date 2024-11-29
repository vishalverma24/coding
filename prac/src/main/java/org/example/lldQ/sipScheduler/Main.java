package org.example.lldQ.sipScheduler;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        SIPManager sipManager = new SIPManager();
        OrderPuncher orderPuncher = new OrderPuncher(sipManager);

        sipManager.createSIP("FundA", 2500, ScheduleType.MONTHLY);
        sipManager.createSIP("FundB", 500, ScheduleType.WEEKLY);
        sipManager.createSIP("FundC", 100, ScheduleType.DAILY);


        sipManager.editSIP("FundC",300,ScheduleType.WEEKLY);


//        sipManager.cancelSIP("FundC");


        LocalDateTime simulationDate = LocalDateTime.now();
        for (int i = 0; i < 60; i++) { // Simulate 60 days
            System.out.println("Day " + (i+1) + " - " + simulationDate);
            orderPuncher.punchOrders(simulationDate);
            simulationDate = simulationDate.plusDays(1);
        }
    }
}

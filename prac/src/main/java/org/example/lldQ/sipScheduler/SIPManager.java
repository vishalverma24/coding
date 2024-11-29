package org.example.lldQ.sipScheduler;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SIPManager {

    Map<String,SIP> sips = new HashMap<>();
    public void createSIP(String fundName, double amount, ScheduleType schedule) {
        sips.put(fundName,new SIP(fundName,amount, LocalDateTime.now(),schedule));
        System.out.println("SIP Created for fund " + fundName);
    }


    public void editSIP(String fundName, double amount, ScheduleType schedule) {
        SIP sip = sips.get(fundName);
        if(sip==null) {
            System.out.println("SIP doesn't exist");
        } else{
            sip.update(amount,schedule);
            System.out.println("SIP " + sip.getFundName() + " updated");
        }
    }

    public void cancelSIP(String fundName) {
        SIP sip = sips.get(fundName);
        if(sip==null) {
            System.out.println("SIP doesn't exist");
        } else{
            sips.remove(fundName);
            System.out.println("SIP " + fundName + " cancelled");
        }
    }

    public Collection<SIP> getSIPS() {
        Collection<SIP> values = sips.values();
        return values;
    }
}

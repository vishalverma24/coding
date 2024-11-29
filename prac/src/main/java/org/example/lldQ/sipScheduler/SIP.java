package org.example.lldQ.sipScheduler;

import java.time.LocalDateTime;

public class SIP {

    private String fundName;
    private double amount;
    private LocalDateTime startDate;
    private ScheduleType scheduleType;
    private LocalDateTime nextPunchDate;

    public SIP(String fundName, double amount, LocalDateTime startDate, ScheduleType scheduleType) {
        this.fundName = fundName;
        this.amount = amount;
        this.startDate = startDate;
        this.scheduleType = scheduleType;
        this.nextPunchDate = calculateNextPunchDate(startDate, scheduleType);
    }


    public void update(double newAmount, ScheduleType schedule) {
        this.amount = newAmount;
        this.scheduleType = schedule;
        this.nextPunchDate = calculateNextPunchDate(LocalDateTime.now(),schedule);
    }
    public LocalDateTime calculateNextPunchDate(LocalDateTime date, ScheduleType type) {
        switch (type) {
            case MONTHLY: return date.plusDays(30);
            case WEEKLY: return date.plusDays(7);
            case DAILY: return date.plusDays(1);
            case FORTNIGHT: return date.plusDays(15);
            default: throw new IllegalArgumentException("Invalid schedule type");
        }
    }

    public boolean isDueToday(LocalDateTime currentDate) {
        return currentDate.toLocalDate().equals(this.nextPunchDate.toLocalDate());
    }

    public void updateNextPunchDate() {
        this.nextPunchDate = calculateNextPunchDate(this.nextPunchDate,this.scheduleType);
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public ScheduleType getScheduleType() {
        return scheduleType;
    }

    public void setScheduleType(ScheduleType scheduleType) {
        this.scheduleType = scheduleType;
    }

    public LocalDateTime getNextPunchDate() {
        return nextPunchDate;
    }

    public void setNextPunchDate(LocalDateTime nextPunchDate) {
        this.nextPunchDate = nextPunchDate;
    }

}

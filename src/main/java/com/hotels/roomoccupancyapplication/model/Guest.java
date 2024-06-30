package com.hotels.roomoccupancyapplication.model;

public class Guest {
    private double willingnessToPay;

    public Guest(double willingnessToPay) {
        this.willingnessToPay = willingnessToPay;
    }

    public Guest(int willingnessToPay) {
        this.willingnessToPay = willingnessToPay;
    }

    public double getWillingnessToPay() {
        return willingnessToPay;
    }

    public void setWillingnessToPay(double willingnessToPay) {
        this.willingnessToPay = willingnessToPay;
    }
}

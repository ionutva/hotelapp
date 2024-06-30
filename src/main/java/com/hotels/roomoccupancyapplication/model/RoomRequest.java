package com.hotels.roomoccupancyapplication.model;

import com.hotels.roomoccupancyapplication.model.Guest;

import java.util.List;

public class RoomRequest {
    private int premiumRooms;
    private int economyRooms;
    private List<Guest> guests;

    public RoomRequest(int premiumRooms, int economyRooms, List<Guest> guests) {
        this.premiumRooms = premiumRooms;
        this.economyRooms = economyRooms;
        this.guests = guests;
    }

    public int getPremiumRooms() {
        return premiumRooms;
    }

    public void setPremiumRooms(int premiumRooms) {
        this.premiumRooms = premiumRooms;
    }

    public int getEconomyRooms() {
        return economyRooms;
    }

    public void setEconomyRooms(int economyRooms) {
        this.economyRooms = economyRooms;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }
}

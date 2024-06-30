package com.hotels.roomoccupancyapplication.services;

import com.hotels.roomoccupancyapplication.model.OptimizationResult;
import com.hotels.roomoccupancyapplication.model.Guest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomOptimizationService {

    public OptimizationResult optimizeRooms(int premiumRooms, int economyRooms, List<Guest> guests) {
        guests.sort((g1, g2) -> Double.compare(g2.getWillingnessToPay(), g1.getWillingnessToPay()));

        int usagePremium = 0;
        int usageEconomy = 0;
        double revenuePremium = 0;
        double revenueEconomy = 0;

        for (Guest guest : guests) {
            if (guest.getWillingnessToPay() >= 100 && usagePremium < premiumRooms) {
                usagePremium++;
                revenuePremium += guest.getWillingnessToPay();
            } else if (guest.getWillingnessToPay() < 100 && usageEconomy < economyRooms) {
                usageEconomy++;
                revenueEconomy += guest.getWillingnessToPay();
            }
            if (usagePremium + usageEconomy == premiumRooms + economyRooms) {
                break;
            }
        }
        if(usagePremium < premiumRooms && usageEconomy == economyRooms){
            ArrayList<Guest> filteredGuests = (ArrayList<Guest>) guests.stream().filter(w -> w.getWillingnessToPay() < 100).collect(Collectors.toList());
            int freeEconomyRooms = premiumRooms - usagePremium;
            for(int i = 0; i < freeEconomyRooms; i++){
                usagePremium++;
                revenuePremium += filteredGuests.get(i).getWillingnessToPay();
            }

            revenueEconomy = 0;
            usageEconomy = 0;
            for(int i = freeEconomyRooms; i < filteredGuests.size(); i++){
                usageEconomy++;
                revenueEconomy += filteredGuests.get(i).getWillingnessToPay();
                if (usageEconomy == economyRooms) {
                    break;
                }
            }
        }

        return new OptimizationResult(usagePremium, revenuePremium, usageEconomy, revenueEconomy);
    }
}


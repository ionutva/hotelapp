package com.hotels.roomoccupancyapplication;

import com.hotels.roomoccupancyapplication.model.Guest;
import com.hotels.roomoccupancyapplication.model.OptimizationResult;
import com.hotels.roomoccupancyapplication.services.RoomOptimizationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoomOccupancyApplicationTests {

    private final RoomOptimizationService service = new RoomOptimizationService();
    List<Guest> guests = List.of(new Guest(23),
            new Guest(45), new Guest(155), new Guest(374), new Guest(22)
            , new Guest(99.99), new Guest(100),
            new Guest(101), new Guest(115), new Guest(209));

    List<Guest> modifiableGuestList = new ArrayList<Guest>(guests);

    @Test
    public void testCalculateOccupancy1() {
        OptimizationResult response = service.optimizeRooms(3, 3, modifiableGuestList);

        assertEquals(3, response.getUsagePremium());
        assertEquals(738, response.getRevenuePremium());
        assertEquals(3, response.getUsageEconomy());
        assertEquals(167.99, response.getRevenueEconomy());
    }
    @Test
    public void testCalculateOccupancy2() {
        OptimizationResult response = service.optimizeRooms(7, 5, modifiableGuestList);

        assertEquals(6, response.getUsagePremium());
        assertEquals(1054, response.getRevenuePremium());
        assertEquals(4, response.getUsageEconomy());
        assertEquals(189.99, response.getRevenueEconomy());
    }
    @Test
    public void testCalculateOccupancy3() {
        OptimizationResult response = service.optimizeRooms(2, 7, modifiableGuestList);

        assertEquals(2, response.getUsagePremium());
        assertEquals(583, response.getRevenuePremium());
        assertEquals(4, response.getUsageEconomy());
        assertEquals(189.99, response.getRevenueEconomy());
    }
    @Test
    public void testCalculateOccupancy4() {
        OptimizationResult response = service.optimizeRooms(8, 2, modifiableGuestList);

        assertEquals(8, response.getUsagePremium());
        assertEquals(1198.99, response.getRevenuePremium());
        assertEquals(2, response.getUsageEconomy());
        assertEquals(45, response.getRevenueEconomy());
    }


}

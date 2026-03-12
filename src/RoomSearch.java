import java.util.HashMap;
import java.util.Map;

public class RoomSearch {

    // Inner class to represent Room Data
    static class Room {
        String typeName;
        int beds;
        int size;
        double price;

        public Room(String typeName, int beds, int size, double price) {
            this.typeName = typeName;
            this.beds = beds;
            this.size = size;
            this.price = price;
        }

        public void display(int availableCount) {
            System.out.println(typeName + ":");
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sqft");
            System.out.println("Price per night: " + price);
            System.out.println("Available: " + availableCount + "\n");
        }
    }

    // Inner class to represent Inventory
    static class RoomInventory {
        private Map<String, Integer> stock = new HashMap<>();

        public void updateStock(String key, int count) {
            stock.put(key, count);
        }

        public Map<String, Integer> getRoomAvailability() {
            return stock;
        }
    }

    /**
     * Displays available rooms along with their details and pricing.
     * Performs read-only access to inventory and room data.
     */
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        System.out.println("Room Search\n");
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check and display Single Room availability
        if (availability.getOrDefault("Single", 0) > 0) {
            singleRoom.display(availability.get("Single"));
        }

        // Check and display Double Room availability
        if (availability.getOrDefault("Double", 0) > 0) {
            doubleRoom.display(availability.get("Double"));
        }

        // Check and display Suite Room availability
        if (availability.getOrDefault("Suite", 0) > 0) {
            suiteRoom.display(availability.get("Suite"));
        }
    }

    /**
     * Main entry point to demonstrate the Room Search output.
     */
    public static void main(String[] args) {
        RoomSearch service = new RoomSearch();

        // 1. Setup Inventory Data
        RoomInventory inventory = new RoomInventory();
        inventory.updateStock("Single", 5);
        inventory.updateStock("Double", 3);
        inventory.updateStock("Suite", 2);

        // 2. Define Room Details
        Room single = new Room("Single Room", 1, 250, 1500.0);
        Room doubleR = new Room("Double Room", 2, 400, 2500.0);
        Room suite = new Room("Suite Room", 3, 750, 5000.0);

        // 3. Trigger Search
        service.searchAvailableRooms(inventory, single, doubleR, suite);
    }
}
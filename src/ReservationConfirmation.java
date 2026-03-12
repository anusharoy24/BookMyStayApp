import java.util.*;

/**
 * =========================================================
 * CLASS - Reservation
 * =========================================================
 * Use Case 5: Represents a booking request.
 */
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
}

/**
 * =========================================================
 * CLASS - RoomInventory
 * =========================================================
 * Manages the counts of available rooms.
 */
class RoomInventory {
    private Map<String, Integer> inventory = new HashMap<>();

    public void addInventory(String type, int count) {
        inventory.put(type, count);
    }

    public Map<String, Integer> getRoomAvailability() {
        return inventory;
    }
}

/**
 * =========================================================
 * CLASS - BookingRequestQueue
 * =========================================================
 * Manages FIFO logic for requests.
 */
class BookingRequestQueue {
    private Queue<Reservation> requestQueue = new LinkedList<>();

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}

/**
 * =========================================================
 * MAIN CLASS - ReservationConfirmation
 * =========================================================
 * Handles Use Case 6: Final Allocation logic.
 */
public class ReservationConfirmation {

    private Set<String> allocatedRoomIds = new HashSet<>();
    private Map<String, Set<String>> assignedRoomsByType = new HashMap<>();

    /**
     * Confirms booking and assigns unique ID.
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.getOrDefault(type, 0) > 0) {
            String roomId = generateRoomId(type);

            // Track assignment
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.computeIfAbsent(type, k -> new HashSet<>()).add(roomId);

            // Update inventory immediately
            inventory.addInventory(type, availability.get(type) - 1);

            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() +
                    ", Room ID: " + roomId);
        }
    }

    private String generateRoomId(String roomType) {
        int count = assignedRoomsByType.getOrDefault(roomType, new HashSet<>()).size() + 1;
        return roomType + "-" + count;
    }

    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        // Setup
        RoomInventory inventory = new RoomInventory();
        inventory.addInventory("Single", 5);
        inventory.addInventory("Suite", 2);

        BookingRequestQueue queue = new BookingRequestQueue();
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        ReservationConfirmation confirmation = new ReservationConfirmation();

        // Execution
        while (queue.hasPendingRequests()) {
            confirmation.allocateRoom(queue.getNextRequest(), inventory);
        }
    }
}
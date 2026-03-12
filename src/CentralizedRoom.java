public class CentralizedRoom {

    // Room properties
    String type;
    int beds;
    int size;
    double pricePerNight;
    int availableRooms;

    // Constructor to initialize the room details
    public CentralizedRoom(String type, int beds, int size, double pricePerNight, int availableRooms) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.pricePerNight = pricePerNight;
        this.availableRooms = availableRooms;
    }

    // Method to display room information as required
    public void displayRoomInfo() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available Rooms: " + availableRooms);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Hotel Room Inventory Status\n");

        // Create room objects
        CentralizedRoom singleRoom = new CentralizedRoom("Single Room", 1, 250, 1500.0, 5);
        CentralizedRoom doubleRoom = new CentralizedRoom("Double Room", 2, 400, 2500.0, 3);
        CentralizedRoom suiteRoom = new CentralizedRoom("Suite Room", 3, 750, 5000.0, 2);

        // Display the room details
        singleRoom.displayRoomInfo();
        doubleRoom.displayRoomInfo();
        suiteRoom.displayRoomInfo();
    }
}

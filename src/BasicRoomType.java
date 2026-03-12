public class BasicRoomType {

    // Room properties
    String type;
    int beds;
    int size;
    double pricePerNight;
    int available;

    // Constructor
    public BasicRoomType(String type, int beds, int size, double pricePerNight, int available) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    // Method to display room details
    public void displayRoomDetails() {
        System.out.println(type + ":");
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sqft");
        System.out.println("Price per night: " + pricePerNight);
        System.out.println("Available: " + available);
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        // Creating room objects
        BasicRoomType singleRoom = new BasicRoomType("Single Room", 1, 250, 1500.0, 5);
        BasicRoomType doubleRoom = new BasicRoomType("Double Room", 2, 400, 2500.0, 3);
        BasicRoomType suiteRoom = new BasicRoomType("Suite Room", 3, 750, 5000.0, 2);

        // Display room details
        singleRoom.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        suiteRoom.displayRoomDetails();
    }
}
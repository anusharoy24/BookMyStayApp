import java.util.*;

/**
 * =========================================================
 * CLASS - AddOnService
 * =========================================================
 * Use Case 7: Add-On Service Selection
 * * Description:
 * This class allows guests with a confirmed Reservation ID
 * to select additional services and calculates the total cost.
 * * @version 7.0
 */
public class AddOnService {

    // Mock data for service prices
    private Map<String, Double> servicePrices;

    public AddOnService() {
        servicePrices = new HashMap<>();
        servicePrices.put("Breakfast", 500.0);
        servicePrices.put("Spa", 1000.0);
        servicePrices.put("Airport Pickup", 1500.0);
    }

    /**
     * Calculates and displays the total add-on cost for a reservation.
     * * @param reservationId The ID generated in the allocation step
     * @param selectedServices List of services the guest wants
     */
    public void processAddOns(String reservationId, List<String> selectedServices) {
        double totalCost = 0.0;

        for (String service : selectedServices) {
            totalCost += servicePrices.getOrDefault(service, 0.0);
        }

        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }

    /**
     * Main entry point to generate the requested output.
     */
    public static void main(String[] args) {
        AddOnService service = new AddOnService();

        // Example: Guest from "Single-1" picks Airport Pickup (1500.0)
        List<String> myAddOns = new ArrayList<>();
        myAddOns.add("Airport Pickup");

        service.processAddOns("Single-1", myAddOns);
    }
}
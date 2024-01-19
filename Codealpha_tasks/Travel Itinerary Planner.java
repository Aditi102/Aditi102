package codealpha;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Destination {
    String name;
    int days;

    public Destination(String name, int days) {
        this.name = name;
        this.days = days;
    }
}

class Itinerary {
    List<Destination> destinations;

    public Itinerary() {
        this.destinations = new ArrayList<>();
    }

    public void addDestination(String name, int days) {
        Destination destination = new Destination(name, days);
        destinations.add(destination);
    }

    public void printItinerary() {
        System.out.println("Your Travel Itinerary:");
        System.out.println("**//////////////////**");
        int totalDays = 0;
        for (Destination destination : destinations) {
            System.out.println(destination.name + ": " + destination.days + " days");
            totalDays += destination.days;
        }
        System.out.println("Total Duration: " + totalDays + " days");
    }
}
public class TravelPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Itinerary itinerary = new Itinerary();

        System.out.println("********** WELCOME **********");

        while (true) {
            System.out.print("Enter destination name (type 'done' to finish): ");
            String destinationName = scanner.nextLine();

            if (destinationName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter duration (in days): ");
            int duration = Integer.parseInt(scanner.nextLine());

            itinerary.addDestination(destinationName, duration);
        }

        itinerary.printItinerary();
        scanner.close();
    }
}

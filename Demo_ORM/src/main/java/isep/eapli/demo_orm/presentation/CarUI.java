package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.domain.Car;
import isep.eapli.demo_orm.domain.GroupCar;
import isep.eapli.demo_orm.application.CarConroller;
import isep.eapli.demo_orm.application.GroupCarController;
import isep.eapli.demo_orm.util.Console;

import java.util.List;

/**
 * UI für Car-Operationen
 */
public class CarUI {
    private final CarConroller carController;

    public CarUI() {
        this.carController = new CarConroller();
    }

    /**
     * Workflow: Benutzer wählt eine GroupCar und erstellt dann Cars darin
     */
    public void manageCarsInGroup() {
        System.out.println("\n=== Manage Cars in Car Group ===");

        try {
            // Zuerst alle verfügbaren GroupCars anzeigen
            List<GroupCar> groupCars = carController.getAllGroupCars();

            if (groupCars.isEmpty()) {
                System.out.println("✗ No Car Groups available. Please create a Car Group first.");
                return;
            }

            System.out.println("\nAvailable Car Groups:");
            for (int i = 0; i < groupCars.size(); i++) {
                System.out.println((i + 1) + ". " + groupCars.get(i));
            }

            int groupChoice = Console.readInteger("\nChoose a Car Group (1-" + groupCars.size() + "): ");

            if (groupChoice < 1 || groupChoice > groupCars.size()) {
                System.out.println("✗ Invalid choice.");
                return;
            }

            GroupCar selectedGroup = groupCars.get(groupChoice - 1);
            System.out.println("\n✓ Selected: " + selectedGroup.getGroupName());

            // Jetzt Cars in dieser GroupCar erstellen
            registerCarsInGroup(selectedGroup);

        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Registriert mehrere Cars in einer ausgewählten GroupCar
     */
    private void registerCarsInGroup(GroupCar selectedGroup) {
        String continueAdding;

        do {
            System.out.println("\n--- Register new Car in " + selectedGroup.getGroupName() + " ---");

            try {
                // Eingaben vom Benutzer
                String licensePlate = Console.readLine("License Plate: ");
                int manufactureYear = Console.readInteger("Manufacture Year: ");
                int acquisitionYear = Console.readInteger("Acquisition Year: ");
                String engineDisplacement = Console.readLine("Engine Displacement (e.g., 2000cc): ");

                // Auto erstellen und speichern
                Car car = new Car(licensePlate, manufactureYear, acquisitionYear,
                                 engineDisplacement, selectedGroup);
                carController.save(car);

                System.out.println("\n✓ Car registered successfully!");
                System.out.println(car);

                continueAdding = Console.readLine("\nAdd another car to this group? (y/n): ");
            } catch (Exception e) {
                System.err.println("✗ Error registering Car: " + e.getMessage());
                e.printStackTrace();
                continueAdding = "n";
            }
        } while (continueAdding.equalsIgnoreCase("y"));

        System.out.println("\n✓ Finished adding cars to " + selectedGroup.getGroupName());
    }

    /**
     * Listet alle registrierten Autos auf
     */
    public void listAllCars() {
        System.out.println("\n=== All Registered Cars ===");

        try {
            Iterable<Car> cars = carController.findAll();

            int count = 0;
            System.out.println("-".repeat(80));
            for (Car car : cars) {
                System.out.println(car);
                count++;
            }
            System.out.println("-".repeat(80));

            if (count == 0) {
                System.out.println("No Cars found.");
            } else {
                System.out.println("Total Cars: " + count);
            }
        } catch (Exception e) {
            System.err.println("✗ Error loading Cars: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Schließt den Controller
     */
    public void close() {
        carController.close();
    }
}

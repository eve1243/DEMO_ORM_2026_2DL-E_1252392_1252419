package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.domain.GroupCar;
import isep.eapli.demo_orm.persistence.GroupCarRepository;
import isep.eapli.demo_orm.persistence.GroupCarController;
import isep.eapli.demo_orm.util.Console;

import java.util.List;

/**
 * UI für GroupCar-Operationen
 */
public class GroupCarUI {
    private final GroupCarRepository repository;

    public GroupCarUI() {
        this.repository = new GroupCarController();
    }


    public void registerCG() {
        System.out.println("\n=== Registring new Groupcars. ===");

        String groupName = Console.readLine("Groupname: ");
        int numOfDoors = Console.readInteger("Number of Doors: ");
        int pricePerDay = Console.readInteger("price per day: ");

        System.out.println("\nClasstype:");
        System.out.println("1. Utility");
        System.out.println("2. Luxury");
        System.out.println("3. Commercial");
        int classTypeChoice = Console.readInteger("Choose a classtype (1-3): ");

        GroupCar.ClassType classType;
        switch (classTypeChoice) {
            case 1:
                classType = GroupCar.ClassType.Utility;
                break;
            case 2:
                classType = GroupCar.ClassType.Luxury;
                break;
            case 3:
                classType = GroupCar.ClassType.Commercial;
                break;
            default:
                System.out.println("Not recocnized. Standard: Utility");
                classType = GroupCar.ClassType.Utility;
        }

        try {
            GroupCar groupCar = new GroupCar(groupName, numOfDoors, pricePerDay, classType);
            repository.save(groupCar);
            System.out.println("\n✓ Groupcar registered!");
            System.out.println(groupCar);
        } catch (Exception e) {
            System.err.println("✗ Error registering GroupCar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Listet alle Groupcars auf
     */
    public void listAllCG() {
        System.out.println("\n=== All Groups of Cars ===");

        try {
            List<GroupCar> groupCars = repository.findAll();

            if (groupCars.isEmpty()) {
                System.out.println("No Groupcars where found.");
            } else {
                System.out.println("Found Groupcars: " + groupCars.size());
                System.out.println("-".repeat(80));
                for (GroupCar cg : groupCars) {
                    System.out.println(cg);
                }
                System.out.println("-".repeat(80));
            }
        } catch (Exception e) {
            System.err.println("✗ Error with loading der Groupcars: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Schließt das Repository
     */
    public void close() {
        repository.close();
    }
}

package isep.eapli.demo_orm.presentation;

import isep.eapli.demo_orm.domain.CarGroup;
import isep.eapli.demo_orm.persistence.CarGroupRepository;
import isep.eapli.demo_orm.persistence.CarGroupRepositoryJPA;
import isep.eapli.demo_orm.util.Console;

import java.util.List;

/**
 * UI für CarGroup-Operationen
 */
public class CarGroupUI {
    private final CarGroupRepository repository;

    public CarGroupUI() {
        this.repository = new CarGroupRepositoryJPA();
    }


    public void registerCG() {
        System.out.println("\n=== Registrierung eines neuen Grupo Automóvel ===");

        String groupName = Console.readLine("Gruppenname: ");
        int numOfDoors = Console.readInteger("Anzahl der Türen: ");
        int pricePerDay = Console.readInteger("Preis pro Tag: ");

        System.out.println("\nKlassentyp:");
        System.out.println("1. Utility");
        System.out.println("2. Luxury");
        System.out.println("3. Commercial");
        int classTypeChoice = Console.readInteger("Wählen Sie den Klassentyp (1-3): ");

        CarGroup.ClassType classType;
        switch (classTypeChoice) {
            case 1:
                classType = CarGroup.ClassType.Utility;
                break;
            case 2:
                classType = CarGroup.ClassType.Luxury;
                break;
            case 3:
                classType = CarGroup.ClassType.Commercial;
                break;
            default:
                System.out.println("Ungültige Auswahl. Standard: Utility");
                classType = CarGroup.ClassType.Utility;
        }

        try {
            CarGroup carGroup = new CarGroup(groupName, numOfDoors, pricePerDay, classType);
            repository.save(carGroup);
            System.out.println("\n✓ Grupo Automóvel erfolgreich registriert!");
            System.out.println(carGroup);
        } catch (Exception e) {
            System.err.println("✗ Fehler beim Registrieren der CarGroup: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Listet alle CarGroups auf
     */
    public void listAllCG() {
        System.out.println("\n=== Alle Grupos Automóveis ===");

        try {
            List<CarGroup> carGroups = repository.findAll();

            if (carGroups.isEmpty()) {
                System.out.println("Keine CarGroups gefunden.");
            } else {
                System.out.println("Gefundene CarGroups: " + carGroups.size());
                System.out.println("-".repeat(80));
                for (CarGroup cg : carGroups) {
                    System.out.println(cg);
                }
                System.out.println("-".repeat(80));
            }
        } catch (Exception e) {
            System.err.println("✗ Fehler beim Abrufen der CarGroups: " + e.getMessage());
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

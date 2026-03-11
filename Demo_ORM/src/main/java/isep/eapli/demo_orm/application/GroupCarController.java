package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.GroupCar;
import isep.eapli.demo_orm.persistence.GroupCarRepository;
import isep.eapli.demo_orm.persistence.GroupCarRepositoryJPA;

import java.util.List;

/**
 * Controller für GroupCar-Operationen im Application Layer
 * Delegiert an die JPA Repository Implementierung
 */
public class GroupCarController {
    private final GroupCarRepository groupCarRepository;

    public GroupCarController() {
        this.groupCarRepository = new GroupCarRepositoryJPA();
    }

    public GroupCarController(GroupCarRepository groupCarRepository) {
        this.groupCarRepository = groupCarRepository;
    }

    /**
     * Erstellt und speichert eine neue GroupCar
     */
    public GroupCar createGroupCar(String groupName, int numOfDoors, int pricePerDay,
                                   GroupCar.ClassType classType) {
        GroupCar groupCar = new GroupCar(groupName, numOfDoors, pricePerDay, classType);
        return groupCarRepository.save(groupCar);
    }

    /**
     * Speichert eine GroupCar
     */
    public GroupCar save(GroupCar groupCar) {
        return groupCarRepository.save(groupCar);
    }

    /**
     * Gibt alle GroupCars zurück
     */
    public List<GroupCar> findAll() {
        return groupCarRepository.findAll();
    }

    /**
     * Schließt das Repository
     */
    public void close() {
        groupCarRepository.close();
    }
}


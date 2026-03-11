package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.GroupCar;

import java.util.List;


public interface GroupCarRepository {

    /**
     * Speichert eine neue GroupCar in der Datenbank
     */
    GroupCar save(GroupCar groupCar);


    /**
     * Gibt alle CarGroups zurück
     */
    List<GroupCar> findAll();


    /**
     * Schließt den EntityManager
     */
    void close();
}


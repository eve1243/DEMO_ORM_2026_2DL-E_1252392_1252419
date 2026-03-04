package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.CarGroup;

import java.util.List;
import java.util.Optional;


public interface CarGroupRepository {

    /**
     * Speichert eine neue CarGroup in der Datenbank
     */
    CarGroup save(CarGroup carGroup);


    /**
     * Gibt alle CarGroups zurück
     */
    List<CarGroup> findAll();


    /**
     * Schließt den EntityManager
     */
    void close();
}


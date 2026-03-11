package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.GroupCar;

import java.util.List;

/**
 * JPA Repository für GroupCar Entities
 * Erweitert die generische JpaRepository Klasse
 */
public class GroupCarRepositoryJPA extends JpaRepository<GroupCar, Long> implements GroupCarRepository {

    @Override
    protected String persistenceUnitName() {
        return "DEMO_ORMPU";
    }

    @Override
    public GroupCar save(GroupCar groupCar) {
        return add(groupCar);
    }

    @Override
    public List<GroupCar> findAll() {
        return super.findAll();
    }

    @Override
    public void close() {
        // EntityManager wird in JpaRepository verwaltet
    }

    // Hier können GroupCar-spezifische Methoden hinzugefügt werden
    // Beispiel: findByClassType, findByPriceRange, etc.
}


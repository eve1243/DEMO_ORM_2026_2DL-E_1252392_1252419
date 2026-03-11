package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.Car;

/**
 * JPA Repository für Car Entities
 * Erweitert die generische JpaRepository Klasse
 */
public class CarRepositoryJPA extends JpaRepository<Car, Long> implements CarRepository {

    @Override
    protected String persistenceUnitName() {
        return "DEMO_ORMPU";
    }

    @Override
    public Car save(Car car) {
        return add(car);
    }

    // findAll() wird von JpaRepository geerbt und gibt List<Car> zurück
    // List implementiert Iterable, daher erfüllt es das CarRepository Interface

    @Override
    public void close() {
        // EntityManager wird in JpaRepository verwaltet
    }

    // Hier können Car-spezifische Methoden hinzugefügt werden
    // Beispiel: findByLicensePlate, findByGroupCar, etc.
}


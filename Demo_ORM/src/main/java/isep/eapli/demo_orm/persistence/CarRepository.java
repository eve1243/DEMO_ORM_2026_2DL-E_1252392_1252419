package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.Car;

public interface CarRepository {
    /**
     * Speichert ein neues Auto in der Datenbank
     */
    Car save(Car car);

    /**
     * Gibt alle Autos zurück
     */
    Iterable<Car> findAll();

    /**
     * Schließt den EntityManager
     */
    void close();
}

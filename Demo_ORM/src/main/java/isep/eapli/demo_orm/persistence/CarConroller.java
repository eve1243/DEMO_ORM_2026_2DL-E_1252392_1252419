package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.Car;
import isep.eapli.demo_orm.domain.GroupCar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

/**
 * Controller für Car-Operationen, implementiert das CarRepository Interface
 */
public class CarConroller implements CarRepository {
    private static final String PERSISTENCE_UNIT_NAME = "DEMO_ORMPU";
    private static EntityManagerFactory emf;
    private final EntityManager em;

    public CarConroller() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        this.em = emf.createEntityManager();
    }

    public CarConroller(EntityManager em) {
        this.em = em;
    }

    /**
     * Speichert ein Auto in der Datenbank
     */
    @Override
    public Car save(Car car) {
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving the Car", e);
        }
    }

    /**
     * Gibt alle Autos zurück
     */
    @Override
    public Iterable<Car> findAll() {
        TypedQuery<Car> query = em.createQuery(
            "SELECT c FROM Car c", Car.class);
        return query.getResultList();
    }

    /**
     * Schließt den EntityManager
     */
    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}

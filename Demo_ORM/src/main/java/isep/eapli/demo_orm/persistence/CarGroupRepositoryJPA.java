package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.CarGroup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;


public class CarGroupRepositoryJPA implements CarGroupRepository {
    private static final String PERSISTENCE_UNIT_NAME = "DEMO_ORMPU";
    private static EntityManagerFactory emf;
    private final EntityManager em;

    public CarGroupRepositoryJPA() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        this.em = emf.createEntityManager();
    }

    public CarGroupRepositoryJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public CarGroup save(CarGroup carGroup) {
        try {
            em.getTransaction().begin();
            em.persist(carGroup);
            em.getTransaction().commit();
            return carGroup;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Fehler beim Speichern der CarGroup", e);
        }
    }


    @Override
    public List<CarGroup> findAll() {
        TypedQuery<CarGroup> query = em.createQuery(
            "SELECT cg FROM CarGroup cg", CarGroup.class);
        return query.getResultList();
    }

    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}


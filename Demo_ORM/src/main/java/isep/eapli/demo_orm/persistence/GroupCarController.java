package isep.eapli.demo_orm.persistence;

import isep.eapli.demo_orm.domain.GroupCar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;


public class GroupCarController implements GroupCarRepository {
    private static final String PERSISTENCE_UNIT_NAME = "DEMO_ORMPU";
    private static EntityManagerFactory emf;
    private final EntityManager em;

    public GroupCarController() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        this.em = emf.createEntityManager();
    }

    public GroupCarController(EntityManager em) {
        this.em = em;
    }

    @Override
    public GroupCar save(GroupCar groupCar) {
        try {
            em.getTransaction().begin();
            em.persist(groupCar);
            em.getTransaction().commit();
            return groupCar;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Error saving the GroupCar", e);
        }
    }


    @Override
    public List<GroupCar> findAll() {
        TypedQuery<GroupCar> query = em.createQuery(
            "SELECT cg FROM GroupCar cg", GroupCar.class);
        return query.getResultList();
    }

    @Override
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
}


package jpaDao;

import dao.IMarqueDAO;
import entité.Additifs;
import entité.Marque;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaMarqueDao implements IMarqueDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();
    @Override
    public Optional<Marque> get(int id) {
        return Optional.ofNullable(em.find(Marque.class, id));
    }

    @Override
    public List<Marque> getAll() {
        Query query = em.createQuery("SELECT a FROM Marque a");
        return query.getResultList();
    }

    @Override
    public void save(Marque marque) {
        executeInsideTransaction(em -> em.persist(marque));

    }

    @Override
    public void update(Marque marque, String[] params) {
        marque.setNom(Objects.requireNonNull(params[0], "Nom cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(marque));

    }

    @Override
    public void delete(Marque marque) {
        executeInsideTransaction(em -> em.remove(marque));

    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }


}

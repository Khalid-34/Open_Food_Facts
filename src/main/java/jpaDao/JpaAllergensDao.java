package jpaDao;

import dao.IAllergieDAO;
import entité.Allergens;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaAllergensDao implements IAllergieDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();

    @Override
    public Optional<Allergens> get(int id) {
        return Optional.ofNullable(em.find(Allergens.class, id));

    }


    @Override
    public List<Allergens> getAll() {
            Query query = em.createQuery("SELECT a FROM Allergens a");
            return query.getResultList();
    }

    @Override
    public void save(Allergens allergens) {

        executeInsideTransaction(em -> em.persist(allergens));

    }

    @Override
    public void update(Allergens allergens, String[] params) {
        allergens.setNom(Objects.requireNonNull(params[0], "Nom cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(allergens));

    }

    @Override
    public void delete(Allergens allergens) {

        executeInsideTransaction(em -> em.remove(allergens));

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

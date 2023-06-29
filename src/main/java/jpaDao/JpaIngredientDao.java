package jpaDao;

import dao.IIngredientDAO;
import entité.Ingredient;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaIngredientDao implements IIngredientDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();

    @Override
    public Optional<Ingredient> get(int id) {
        return Optional.ofNullable(em.find(Ingredient.class, id));
    }

    @Override
    public List<Ingredient> getAll() {
        Query query = em.createQuery("SELECT i FROM Ingredient i");
        return query.getResultList();
    }

    @Override
    public void save(Ingredient ingredient) {

        executeInsideTransaction(em -> em.persist(ingredient));

    }

    @Override
    public void update(Ingredient ingredient, String[] params) {
        ingredient.setNom(Objects.requireNonNull(params[0], "Nom cannot be null"));
        executeInsideTransaction(em -> em.merge(ingredient));

    }

    @Override
    public void delete(Ingredient ingredient) {
        executeInsideTransaction(entityManager -> entityManager.remove(ingredient));
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

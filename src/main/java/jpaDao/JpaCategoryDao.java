package jpaDao;

import dao.ICategoryDAO;
import entité.Category;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaCategoryDao implements ICategoryDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();
    @Override
    public Optional<Category> get(int id) {
        return Optional.ofNullable(em.find(Category.class, id));
    }

    @Override
    public List<Category> getAll() {
        Query query = em.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }

    @Override
    public void save(Category category) {

        executeInsideTransaction(em -> em.persist(category));

    }

    @Override
    public void update(Category category, String[] params) {
        category.setNom(Objects.requireNonNull(params[0], "Name cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(category));

    }

    @Override
    public void delete(Category category) {
        executeInsideTransaction(em -> em.remove(category));

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

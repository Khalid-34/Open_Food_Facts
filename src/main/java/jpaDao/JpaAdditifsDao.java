package jpaDao;

import dao.IAdditifDAO;
import entité.Additifs;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaAdditifsDao implements IAdditifDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();
    @Override
    public Optional<Additifs> get(int id) {
        return Optional.ofNullable(em.find(Additifs.class, id));
    }

    @Override
    public List<Additifs> getAll() {
        Query query = em.createQuery("SELECT a FROM Additifs a");
        return query.getResultList();
    }

    @Override
    public void save(Additifs additifs) {
        executeInsideTransaction(em -> em.persist(additifs));

    }

    @Override
    public void update(Additifs additifs, String[] params) {
        additifs.setCode(Objects.requireNonNull(params[0], "Code cannot be null"));
        additifs.setNom(Objects.requireNonNull(params[1], "Nom cannot be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(additifs));

    }

    @Override
    public void delete(Additifs additifs) {

        executeInsideTransaction(em -> em.remove(additifs));

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

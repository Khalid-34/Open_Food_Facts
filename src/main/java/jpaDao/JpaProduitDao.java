package jpaDao;

import dao.IProduitDAO;
import entité.Produit;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class JpaProduitDao implements IProduitDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("food");
    EntityManager em = emf.createEntityManager();
    @Override
    public Optional<Produit> get(int id) {
        return Optional.ofNullable(em.find(Produit.class, id));
    }

    @Override
    public List<Produit> getAll() {
        Query query = em.createQuery("SELECT p FROM Produit p");
        return query.getResultList();
    }

    @Override
    public void save(Produit produit) {
        executeInsideTransaction(em -> em.persist(produit));

    }

    @Override
    public void update(Produit produit, String[] params) {

    }

    @Override
    public void update(Produit produit, String[] params, int[] para) {

    }

    @Override
    public void update(Produit produit, String[] params, int[] para, double[] pa) {
        produit.setNom(Objects.requireNonNull(params[0], "Nom cannot be null"));
        produit.setGrade(Objects.requireNonNull(params[1], "Grade cannot be null"));
        produit.setQuantite(Objects.requireNonNull(para[2], "Quantite cannot be null"));
        produit.setConditionnement(Objects.requireNonNull(params[3], "Conditionnement cannot be null"));
        produit.setNutritionGradeFr(Objects.requireNonNull(params[4], "nutritionGradeFr cannot be null"));
        produit.setGraisse100g(Objects.requireNonNull(pa[5], "Graisse100g cannot be null"));
        produit.setSucres100g(Objects.requireNonNull(pa[6], "Sucres100g cannot be null"));
        produit.setFibres100g(Objects.requireNonNull(pa[7], "fibres100g cannot be null"));
        produit.setProteines100g(Objects.requireNonNull(pa[8], "proteines100g cannot be null"));
        produit.setSel100g(Objects.requireNonNull(pa[8], "sel100g cannot be null"));

    }

    @Override
    public void delete(Produit produit) {
        executeInsideTransaction(em -> em.remove(produit));

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

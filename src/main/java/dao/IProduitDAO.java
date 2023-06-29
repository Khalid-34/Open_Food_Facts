package dao;

import entité.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitDAO extends Dao<Produit>{
    @Override
    Optional<Produit> get(int id);

    @Override
    List<Produit> getAll();

    @Override
    void save(Produit produit);

    @Override
    void update(Produit produit, String[] params);

    void update(Produit produit, String[] params, int[] para);

    void update(Produit produit, String[] params, int[] para, double[] pa);

    @Override
    void delete(Produit produit);
}

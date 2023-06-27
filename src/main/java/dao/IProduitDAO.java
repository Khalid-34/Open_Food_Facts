package dao;

import entities.Produit;

import java.util.List;

public interface IProduitDAO extends IDao<Produit>{
    @Override
    List<Produit> getAll();

    @Override
    void save(Produit produit);
}

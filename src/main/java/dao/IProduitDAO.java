package dao;

import entities.Produit;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<Additif>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type Produits.
 */
public interface IProduitDAO extends IDao<Produit>{
    @Override
    List<Produit> getAll();

    @Override
    void save(Produit produit);
}

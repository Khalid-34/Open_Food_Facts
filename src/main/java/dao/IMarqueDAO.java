package dao;

import entities.Marque;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<Additif>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type Marque.
 */
public interface IMarqueDAO extends IDao<Marque>{

    @Override
    List<Marque> getAll() throws Exception;

    @Override
    void save(Marque marque) throws Exception;
}

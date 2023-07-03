package dao;

import entities.Additif;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<T>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type Additif.
 */
public interface IAdditifDAO extends IDao<Additif> {
    @Override
    List<Additif> getAll() throws Exception;

    @Override
    void save(Additif additif) throws Exception;
}

package dao;

import entities.Allergie;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<T>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type Allergene.
 */
public interface IAllergieDAO extends IDao<Allergie>{
    @Override
    List<Allergie> getAll() throws Exception;

    @Override
    long save(Allergie allergie) throws Exception;
}

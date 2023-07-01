package dao;

import entities.Category;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<T>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type category.
 */
public interface ICategoryDAO extends IDao<Category>{
    @Override
    List<Category> getAll() throws Exception;

    @Override
    long save(Category category) throws Exception;
}

package dao;

import entities.Ingredient;

import java.util.List;

/**
 * @author kone mamoudou
 * étend de l'interface IDao<Additif>.
 * vutilisée pour définir un contrat  de persistance (sauvegarde, récupération, etc.)
 * des objets de type Ingredient.
 */
public interface IIngredientDAO extends IDao<Ingredient>{
    @Override
    List<Ingredient> getAll() throws Exception;

    @Override
    long save(Ingredient ingredient) throws Exception;
}

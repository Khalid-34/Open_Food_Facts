package dao;

import entité.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IIngredientDAO extends Dao<Ingredient>{
    @Override
    Optional<Ingredient> get(int id);

    @Override
    List<Ingredient> getAll();

    @Override
    void save(Ingredient ingredient);

    @Override
    void update(Ingredient ingredient, String[] params);

    @Override
    void delete(Ingredient ingredient);
}

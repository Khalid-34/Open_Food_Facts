package dao;

import entities.Ingredient;

import java.util.List;

public interface IIngredientDAO extends IDao<Ingredient>{
    @Override
    List<Ingredient> getAll() throws Exception;

    @Override
    void save(Ingredient ingredient) throws Exception;
}

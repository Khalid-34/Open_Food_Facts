package dao;

import entité.Allergens;

import java.util.List;
import java.util.Optional;

public interface IAllergieDAO extends Dao<Allergens>{
    @Override
    Optional<Allergens> get(int id);

    @Override
    List<Allergens> getAll();

    @Override
    void save(Allergens allergens);

    @Override
    void update(Allergens allergens, String[] params);

    @Override
    void delete(Allergens allergens);
}

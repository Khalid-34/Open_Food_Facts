package dao;

import entité.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryDAO extends Dao<Category>{

    @Override
    Optional<Category> get(int id);

    @Override
    List<Category> getAll();

    @Override
    void save(Category category);

    @Override
    void update(Category category, String[] params);

    @Override
    void delete(Category category);
}

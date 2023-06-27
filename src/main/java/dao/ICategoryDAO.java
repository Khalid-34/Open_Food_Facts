package dao;

import entities.Category;

import java.util.List;

public interface ICategoryDAO extends IDao<Category>{
    @Override
    List<Category> getAll() throws Exception;

    @Override
    void save(Category category) throws Exception;
}

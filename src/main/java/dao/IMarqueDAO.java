package dao;

import entities.Marque;

import java.util.List;

public interface IMarqueDAO extends IDao<Marque>{

    @Override
    List<Marque> getAll() throws Exception;

    @Override
    void save(Marque marque) throws Exception;
}

package dao;

import entities.Additif;

import java.util.List;

public interface IAdditifDAO extends IDao<Additif> {
    @Override
    List<Additif> getAll() throws Exception;

    @Override
    void save(Additif additif) throws Exception;
}

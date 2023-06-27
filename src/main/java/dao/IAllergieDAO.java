package dao;

import entities.Allergie;

import java.util.List;

public interface IAllergieDAO extends IDao<Allergie>{
    @Override
    List<Allergie> getAll() throws Exception;

    @Override
    void save(Allergie allergie) throws Exception;
}

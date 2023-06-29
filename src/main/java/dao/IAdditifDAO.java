package dao;

import entité.Additifs;

import java.util.List;
import java.util.Optional;

public interface IAdditifDAO extends Dao<Additifs>{
    @Override
    Optional<Additifs> get(int id);

    @Override
    List<Additifs> getAll();

    @Override
    void save(Additifs additifs);

    @Override
    void update(Additifs additifs, String[] params);

    @Override
    void delete(Additifs additifs);
}

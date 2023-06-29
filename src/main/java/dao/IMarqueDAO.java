package dao;

import entité.Marque;

import java.util.List;
import java.util.Optional;

public interface IMarqueDAO extends Dao<Marque>{
    @Override
    Optional<Marque> get(int id);

    @Override
    List<Marque> getAll();

    @Override
    void save(Marque marque);

    @Override
    void update(Marque marque, String[] params);

    @Override
    void delete(Marque marque);
}

package dao;

import java.util.List;

/**
 * Interface Dao  API abstraite qui effectue des opérations CRUD sur des objets de type T
 * @author  kone mamoudou
 * @param <T>
 */

public interface IDao <T>{

    List<T> getAll() throws Exception;;
    void save(T t) throws Exception;;
}

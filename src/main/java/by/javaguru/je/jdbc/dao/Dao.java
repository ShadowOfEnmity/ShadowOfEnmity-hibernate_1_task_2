package by.javaguru.je.jdbc.dao;

import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public interface Dao<K, E, S extends Session> {
    E update(E entity, S session);

    List<E> findAll(S session);

    Optional<E> findById(K id, S session);

    E save(E entity, S session);

    void delete(K id, S session);

}

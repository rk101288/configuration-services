package com.rovergames.example;

import java.util.Optional;

/**
 * User: Richa
 * Date: 3/21/15
 */
public interface ServiceInterface<E, ID> {

    E create(E object);

    void delete(ID id);

    Optional<E> getById(ID id);

    void update(E object);
}

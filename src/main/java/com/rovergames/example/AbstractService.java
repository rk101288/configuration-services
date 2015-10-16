package com.rovergames.example;

import com.rovergames.example.entities.AbstractEntity;
import com.rovergames.example.exceptions.BadRequestException;
import com.rovergames.example.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * User: Richa
 * Date: 3/21/15
 */
public abstract class AbstractService<E extends AbstractEntity, R extends CrudRepository<E, String>> implements ServiceInterface<E, String> {
    private static final String ID_ON_POST = "ID cannot be accepted while creating a new entity.";
    private static final String NOT_FOUND = "Entity with ID %s not found.";

    @Autowired
    public R repository;

    /**
     * Returns an entity by its id
     * @param id The id of the entity
     * @return The entity
     */
    public Optional<E> getById(String id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    /**
     * Creates an entity
     * @param entity The entity to create in db
     * @return The newly created entity
     */
    public E create(E entity) {
        if(entity.getId() != null) {
            throw new BadRequestException(ID_ON_POST);
        }

        return repository.save(entity);
    }

    /**
     * Deletes an entity
     * @param entity to be updated. Must include db ID.
     */
    public void update(E entity) {
        if(repository.findOne(entity.getId()) == null) {
            throw new ResourceNotFoundException(String.format(NOT_FOUND, entity.getId()));
        }
        repository.save(entity);
    }

    /**
     * Deletes an entity
     * @param id The id of the entity to delete
     */
    public void delete(String id) {
        if(repository.findOne(id) == null) {
            throw new ResourceNotFoundException(String.format(NOT_FOUND, id));
        }
        repository.delete(id);
    }
}

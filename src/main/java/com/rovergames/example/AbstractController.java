package com.rovergames.example;

import com.rovergames.example.entities.AbstractEntity;
import com.rovergames.example.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

public abstract class AbstractController<E extends AbstractEntity, S extends ServiceInterface<E, String>> {
    private static final String MISMATCH_IDS = "ID in the path should match the ID of the entity for update.";

    @Autowired
    public S service;

    /**
     * Search for an entity by its id
     * @param id The id of the entity
     * @return The entity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<E> getById(@PathVariable String id) {
        //TODO Conditional GET.
        Optional<E> entity = service.getById(id);

        if(!entity.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(entity.get(), HttpStatus.OK);
        }
    }

    /**
     * Creates a new entity
     * @param entity Entity to create
     * @return Created entity
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<E> add (@RequestBody E entity) {
        E result = service.create(entity);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
            .fromCurrentRequest().path("/{id}")
            .buildAndExpand(result.getId()).toUri());

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update (@PathVariable String id, @RequestBody E entity) {
        if(!id.equals(entity.getId())) {
            throw new BadRequestException(MISMATCH_IDS);
        }
        service.update(entity);
    }

    /**
     * Deletes an entity
     * @param id Id of the entity to delete
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable String id){
        service.delete(id);
    }
}

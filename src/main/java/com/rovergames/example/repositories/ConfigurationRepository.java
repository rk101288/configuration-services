package com.rovergames.example.repositories;

import com.rovergames.example.entities.Configuration;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends PagingAndSortingRepository<Configuration, String> {

}

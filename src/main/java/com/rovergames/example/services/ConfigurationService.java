package com.rovergames.example.services;

import com.google.common.collect.Lists;
import com.rovergames.example.AbstractService;
import com.rovergames.example.entities.Configuration;
import com.rovergames.example.repositories.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService extends AbstractService<Configuration, ConfigurationRepository>{
    @Autowired
    private ConfigurationRepository configurationRepository;

    public List<Configuration> getAllConfigurations() {
        return Lists.newArrayList(configurationRepository.findAll());
    }

}

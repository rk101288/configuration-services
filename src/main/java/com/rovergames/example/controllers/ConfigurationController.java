package com.rovergames.example.controllers;

import com.rovergames.example.AbstractController;
import com.rovergames.example.entities.Configuration;
import com.rovergames.example.services.ConfigurationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController extends AbstractController<Configuration, ConfigurationService> {

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<List<Configuration>> getAllConfigs() {
        List<Configuration> entities = service.getAllConfigurations();

        return new ResponseEntity<>(entities, HttpStatus.OK);
    }
}

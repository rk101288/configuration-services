package com.rovergames.example.services;

import com.rovergames.example.AbstractService;
import com.rovergames.example.entities.User;
import com.rovergames.example.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService <User, UserRepository> {
}

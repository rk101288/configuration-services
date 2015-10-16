package com.rovergames.example.controllers;

import com.rovergames.example.AbstractController;
import com.rovergames.example.entities.User;
import com.rovergames.example.services.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends AbstractController<User, UserService> {
}

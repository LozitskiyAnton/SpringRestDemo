package ru.fox.service.services;

import ru.fox.service.forms.UserForm;
import ru.fox.service.models.User;

import java.util.List;

public interface UsersService {


    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}

package ru.fox.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fox.service.forms.UserForm;
import ru.fox.service.models.Role;
import ru.fox.service.models.State;
import ru.fox.service.models.User;
import ru.fox.service.repositories.UsersReposytory;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
   @Autowired
   private UsersReposytory usersReposytory;

   @Autowired
   private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user= User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .hashPassword(hashPassword)
                .login(userForm.getLogin())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersReposytory.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersReposytory.findAll();
    }

    @Override
    public User findOne(Long userId) {
        return usersReposytory.findOne(userId);
    }
}

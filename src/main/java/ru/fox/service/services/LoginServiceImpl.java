package ru.fox.service.services;


import org.apache.commons.lang3.RandomStringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.fox.service.forms.LoginForm;
import ru.fox.service.models.Token;
import ru.fox.service.models.User;
import ru.fox.service.repositories.TokensRepository;
import ru.fox.service.repositories.UsersReposytory;
import ru.fox.service.transfer.TokenDto;

import java.util.Optional;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersReposytory usersReposytory;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> userOptional = usersReposytory.findByLogin(loginForm.getLogin());

        if (userOptional.isPresent()){
            User user  = userOptional.get();
            if (passwordEncoder.matches(loginForm.getPassword(),user.getHashPassword())){
                Token token= Token.builder()
                        .user(user)
                        .value(RandomStringUtils.random(10,true,true))
                        .build();
                tokensRepository.save(token);
                return TokenDto.from(token);
            }

        } throw new IllegalArgumentException("User not found");



    }
}

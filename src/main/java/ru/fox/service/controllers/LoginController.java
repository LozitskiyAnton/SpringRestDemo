package ru.fox.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fox.service.forms.LoginForm;
import ru.fox.service.models.Token;
import ru.fox.service.services.LoginService;
import ru.fox.service.transfer.TokenDto;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login (@RequestBody LoginForm loginForm){
        return ResponseEntity.ok(loginService.login(loginForm));
    }
}

package ru.fox.service.services;

import ru.fox.service.forms.LoginForm;
import ru.fox.service.transfer.TokenDto;

public interface LoginService {
    TokenDto login (LoginForm loginForm);
}

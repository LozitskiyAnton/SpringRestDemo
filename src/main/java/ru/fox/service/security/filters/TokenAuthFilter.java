package ru.fox.service.security.filters;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.fox.service.security.token.TokenAuthentication;

import javax.servlet.*;
import java.io.IOException;

public class TokenAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request  = (HttpServletRequest) servletRequest;
        String token = request.getParameter("token");
        TokenAuthentication authentication=new TokenAuthentication(token);;
        if (token == null){
           authentication.setAuthenticated(false);
        }
        else {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }

    @Override
    public void destroy() {

    }
}

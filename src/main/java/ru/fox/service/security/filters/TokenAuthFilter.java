package ru.fox.service.security.filters;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.fox.service.security.token.TokenAuthentication;

import javax.servlet.*;
import java.io.IOException;
@Component
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
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

package com.osoleksandr.filter;

import com.osoleksandr.dao.UserDao;
import com.osoleksandr.dao.UserDaoImpl;
import com.osoleksandr.factory.Factory;
import com.osoleksandr.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserFilter implements Filter {

    private UserDaoImpl userDao;
    private final String TOKEN = "TOKEN";
    private List<String> protectedUrl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = Factory.getUserDao();
        protectedUrl.add("/root/userPage");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpRequest.getCookies();
        String uri = httpRequest.getRequestURI();

        if (protectedUrl.contains(uri)) {
            String token = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName().toUpperCase();
                if (TOKEN.equals(name)) {
                    token = cookie.getValue();
                    User user = userDao.findByToken(token);
                    request.setAttribute("user", user);
                }
            }
            if (token == null) {
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

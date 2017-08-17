package com.osoleksandr.filter;

import com.osoleksandr.dao.UserDaoImpl;
import com.osoleksandr.factory.Factory;
import com.osoleksandr.model.Roles;
import com.osoleksandr.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminFilter implements Filter{

    private UserDaoImpl userDao;
    private final String TOKEN = "TOKEN";
    private List<String> protectedUrl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userDao = Factory.getUserDao();
        protectedUrl.add("/root/adminPage");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie[] cookies = httpServletRequest.getCookies();
        String uri = httpServletRequest.getRequestURI();

        if (protectedUrl.contains(uri)) {
            String token = null;
            for (Cookie cookie : cookies) {
                String name = cookie.getName().toLowerCase();
                if (TOKEN.equals(name)) {
                    token = cookie.getValue();
                    User user = userDao.findByToken(token);
                    if (user.getRoles().contains(Roles.ADMIN)) {
                        request.setAttribute("user", user);
                    } else {
                        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
                    }
                }
            }
            if (token == null) {
                request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

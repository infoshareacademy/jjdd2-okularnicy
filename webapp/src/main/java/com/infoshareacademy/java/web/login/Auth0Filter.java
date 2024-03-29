package com.infoshareacademy.java.web.login;

import com.auth0.SessionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter class to check if a valid session exists. This will be true if the User Id is present.
 */
@WebFilter(urlPatterns = "/finanse/*")
public class Auth0Filter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String accessToken = (String) SessionUtils.get(req, "accessToken");
        String idToken = (String) SessionUtils.get(req, "idToken");
        if (accessToken == null && idToken == null) {
            res.sendRedirect(request.getServletContext().getContextPath() + "/login");
            return;
        }
        next.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }
}
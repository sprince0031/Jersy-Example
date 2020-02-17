package com.sprince0031;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    private static final String AUTH_HEADER = "Authorization";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        String authCredentials = req.getHeader(AUTH_HEADER);
        
        boolean authStatus = new AuthService().authenticate(authCredentials);

        if (authStatus) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            PrintWriter out = res.getWriter();
            out.println("<h1>" + HttpServletResponse.SC_UNAUTHORIZED + " - Unauthorised!</h1>");
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @Override
    public void destroy() {
    }

}
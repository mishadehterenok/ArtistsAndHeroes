package com.example.artistsdemoee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/create")
public class SneakyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.getParameterMap()
                .forEach((name, values) -> System.out.println(name + " : " + String.join(", ", values)));
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

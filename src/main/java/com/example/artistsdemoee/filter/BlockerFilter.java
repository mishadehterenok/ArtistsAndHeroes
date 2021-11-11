package com.example.artistsdemoee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "Unsafe")
public class BlockerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.getRequestDispatcher("/resources/jsp/safe.jsp").forward(servletRequest,servletResponse);
        if (servletResponse instanceof HttpServletResponse){
            ((HttpServletResponse) servletResponse).sendRedirect("/safe");
        }
    }
}

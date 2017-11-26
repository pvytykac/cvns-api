package net.pvytykac.cvns;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Paly
 * @since 2017-11-26
 */
@WebFilter
public class ResponseFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("applying CORS filter");
        response.addHeader("Access-Control-Allow-Origin", "*");
        if (request.getHeader("Access-Control-Request-Method") != null
                && "OPTIONS".equals(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Methods",
                    "GET, POST, PUT, DELETE");
            response.addHeader("Access-Control-Allow-Headers",
                    "X-Requested-With,Origin,Content-Type, Accept");
        }
        filterChain.doFilter(request, response);
    }
}

package com.smartqueue.smartqueue.jwt;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.smartqueue.smartqueue.entity.User;
import com.smartqueue.smartqueue.repository.UserRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        String path = request.getServletPath();

        return path.equals("/users/login")
                || path.equals("/users/register")
                || path.equals("/auth/login")
                || path.equals("/auth/register");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {

                String token = authHeader.substring(7);

                String email = jwtUtil.extractUsername(token);

                if (email != null) {

                    User user = userRepository.findByEmail(email);

                    if (user != null && jwtUtil.validateToken(token, email)) {

                      UsernamePasswordAuthenticationToken authentication =
        new UsernamePasswordAuthenticationToken(
                user,
                null,
                Collections.singletonList(
                    new org.springframework.security.core.authority.SimpleGrantedAuthority("ROLE_USER")
                )
        );

                        SecurityContextHolder.getContext()
                                .setAuthentication(authentication);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }
}
package com.proyecto.backend.app.backend_app.auth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.backend.app.backend_app.auth.TokenJwtConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    } 


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)throws IOException, ServletException {
            
        String header = request.getHeader(TokenJwtConfig.HEADER_AUTHORIZATION);
        if(header == null || !header.startsWith(TokenJwtConfig.PREFIX_TOKEN)){
            chain.doFilter(request, response);
            return;
        }
        String token = header.replace(TokenJwtConfig.PREFIX_TOKEN, "");
        byte [] tokendecodeBytes = Base64.getDecoder().decode(token);
        String tokenDeCode = new String(tokendecodeBytes);
        String[] tokenArr = tokenDeCode.split(".");
        String secret = tokenArr[0];//algun token con alguna frase secreta 
        String username = tokenArr[1];//username
        

        if(TokenJwtConfig.SECRET_KEY.equals(secret)){
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));   
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        }else{
            Map<String,String>body = new HashMap<>();
            body.put("message", "El token no es valido");
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(403);
            response.setContentType("application/jason");
        }
    }
}

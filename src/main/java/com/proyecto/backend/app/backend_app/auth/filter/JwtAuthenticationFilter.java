package com.proyecto.backend.app.backend_app.auth.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.boot.autoconfigure.session.Servlet;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.AuthenticationException;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.backend.app.backend_app.model.entities.Usuario;


public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private AuthenticationManager authenticationManager;

   public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;}

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario = null;
        String correo = null;
        String contrasena = null;
       try{
       usuario = new ObjectMapper().readValue(request.getInputStream(),Usuario.class);

       } catch(StreamReadException e){
        e.printStackTrace();
       } catch (DatabindException e){
        e.printStackTrace();
       } catch (IOException e){
        e.printStackTrace();
       } 
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(correo, contrasena);
        return authenticationManager.authenticate(authenticationToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,FilterChain chain,Authentication authResult) throws IOException , ServletException {

        String username = ((org.springframework.security.core.userdetails.User)authResult.getPrincipal()).getUsername();
        String originalInput = "algun token con frase secreta" + username;
        String token = Base64.getEncoder().encodeToString(originalInput.getBytes());
        response.addHeader("Authorization","Bearer " + token);

        Map<String, Object> body = new HashMap<>();
        body.put("token", token);
        body.put("message",String.format("has iniciado sesion con exito",username));
        body.put("username", username);
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException{
        Map<String, Object> body = new HashMap<>();
        body.put("message", "Error de autenticacion: username o password incorrectos");
        body.put("error", failed.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
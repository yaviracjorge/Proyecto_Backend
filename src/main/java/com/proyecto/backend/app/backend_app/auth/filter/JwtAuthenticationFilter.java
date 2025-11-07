package com.proyecto.backend.app.backend_app.auth.filter;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
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
       try{
        Usuario usuario = null;
        String correo = null;
        String contrasena = null;
        usuario = new ObjectMapper().readValue(request.getInputStream(),Usuario.class);
       } catch(StreamReadException e){
        e.printStackTrace();
       } catch (DatabindException e){
        e.printStackTrace();
       } catch (IOException e){
        e.printStackTrace();
       } 
        
    }
}
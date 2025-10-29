package com.proyecto.backend.app.backend_app.servicies;

import com.proyecto.backend.app.backend_app.model.entities.Usuario;
import com.proyecto.backend.app.backend_app.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    @Transactional (readOnly = true)
    public List<Usuario>findAll() {
        return (List<Usuario>)usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario user) {
        return usuarioRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);

    }

    @Override
    @Transactional
    public Optional<Usuario> update(Long id, Usuario user) {
        return usuarioRepository.findById(id).map(existingUser -> {
            existingUser.setCorreo(user.getCorreo());
            existingUser.setContrasena(user.getContrasena());
            return usuarioRepository.save(existingUser);
        });
    }


}

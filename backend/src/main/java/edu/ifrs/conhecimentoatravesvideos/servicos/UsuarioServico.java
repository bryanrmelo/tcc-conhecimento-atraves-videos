package edu.ifrs.conhecimentoatravesvideos.servicos;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public boolean usuarioExiste(long id) {
        return usuarioRepositorio.existsById(id);
    }

    public Usuario getUsuario(Usuario usuario) {
        Optional<Usuario> u = usuarioRepositorio.findById(usuario.getId());
        try {
            return u.get();
        } catch(NoSuchElementException e) {
            return null;
        }
        
    }

}

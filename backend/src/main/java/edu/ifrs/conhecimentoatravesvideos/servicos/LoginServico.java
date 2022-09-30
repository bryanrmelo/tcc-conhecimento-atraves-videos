package edu.ifrs.conhecimentoatravesvideos.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ifrs.conhecimentoatravesvideos.api.dto.UsuarioDTO;
import edu.ifrs.conhecimentoatravesvideos.api.mapeadores.UsuarioMapeador;
import edu.ifrs.conhecimentoatravesvideos.excecoes.LoginInvalidoException;
import edu.ifrs.conhecimentoatravesvideos.model.Usuario;
import edu.ifrs.conhecimentoatravesvideos.repositorios.UsuarioRepositorio;

@Service
public class LoginServico {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioMapeador usuarioMapeador;

    public boolean validar(UsuarioDTO usuarioDTO) throws LoginInvalidoException {
        Usuario usuario = usuarioMapeador.converterParaEntidade(usuarioDTO);

        if(usuarioRepositorio.exists(usuario.getNome(), usuario.getSenha()) == 1) {
            return true;
        } else {
            throw new LoginInvalidoException();
        }
    }
    
}

package edu.ifrs.conhecimentoatravesvideos.api.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifrs.conhecimentoatravesvideos.api.dto.UsuarioDTO;
import edu.ifrs.conhecimentoatravesvideos.excecoes.LoginInvalidoException;
import edu.ifrs.conhecimentoatravesvideos.servicos.LoginServico;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/autenticar")
public class LoginControleApi {

    @Autowired
    private LoginServico loginServico;

    @PostMapping
    @ResponseBody
    public void logar(@RequestBody UsuarioDTO usuarioDTO) throws LoginInvalidoException {
        loginServico.validar(usuarioDTO);

    }

}
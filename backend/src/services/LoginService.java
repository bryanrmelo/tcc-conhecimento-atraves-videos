package services;

import javax.inject.Inject;
import javax.json.Json;

import model.entities.Usuario;
import repository.UsuarioRepository;
import util.jsonConverter;

public class LoginService {

	@Inject
	UsuarioRepository usuarioRepo;
	
	public boolean fazerLogin(Json json) {
		Usuario usuario = jsonConverter.jsonParaUsuario(json);
		if (usuarioRepo.usuarioExiste(usuario)) {
			
		}
		return false;
	}
}

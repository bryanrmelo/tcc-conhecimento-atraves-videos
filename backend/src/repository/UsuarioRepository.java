package repository;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import model.entities.Usuario;
import model.entities.jpa.EntityManagerExtended;
import model.entities.qualifier.DataRepository;

public class UsuarioRepository {

	@Inject
	@DataRepository
	private EntityManagerExtended em;
	
	public boolean usuarioExiste(Usuario usuario) {
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("login", usuario.getLogin());
		return (Integer) em.findFirstWithNamedQuery(Usuario.USUARIO_EXISTE, parametros, Integer.class) != 0? true : false;
	}
}


package model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import enums.TipoUsuarioEnum;
import util.MD5Converter;

@Entity
@SequenceGenerator(name = "UsuarioSeq", sequenceName = "USUARIO_SEQ", allocationSize = 0)
@NamedQueries({
		@NamedQuery(name = Usuario.USUARIO_EXISTE, query = "SELECT COUNT(u) from Usuario as u where u.login = :login"), })
public class Usuario {

	public static final String USUARIO_EXISTE = "usuario.existe";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UsuarioSeq")
	private Long id;

	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "tipo", nullable = false)
	private TipoUsuarioEnum tipoUsuario;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = MD5Converter.convertStringToMd5(senha);
	}
	
	public String getTipoUsuario() {
		//RETORNA STRING NÃO TIPO USUÁRIO
		return tipoUsuario.getDescricao();
	}

	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}

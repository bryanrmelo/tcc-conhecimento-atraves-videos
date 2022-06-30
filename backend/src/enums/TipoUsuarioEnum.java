package enums;

public enum TipoUsuarioEnum {

	ADMINISTRADOR("Administrador"),
	PADRAO("Padrão"),
	ESPECIALISTA("Especialista");
	
	private String descricao;
	
	TipoUsuarioEnum(String descricao) {
		this.descricao = descricao;
		
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}

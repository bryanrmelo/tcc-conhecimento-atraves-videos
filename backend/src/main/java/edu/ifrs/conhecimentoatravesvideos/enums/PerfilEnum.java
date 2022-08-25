public class PerfilEnum {
 
    ADMIN("ADMIN"), USUARIO("USUARIO");

    private String descricao;
    
    private PerfilEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }


}

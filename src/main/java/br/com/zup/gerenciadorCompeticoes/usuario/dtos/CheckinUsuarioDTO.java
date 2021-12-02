package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

public class CheckinUsuarioDTO {

    private String email;
    private int id;
    private String codigoValidacao;


    public CheckinUsuarioDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoValidacao() {
        return codigoValidacao;
    }

    public void setCodigoValidacao(String codigoValidacao) {
        this.codigoValidacao = codigoValidacao;
    }

}

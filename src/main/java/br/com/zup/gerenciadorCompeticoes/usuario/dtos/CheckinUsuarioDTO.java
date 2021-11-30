package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

public class CheckinUsuarioDTO {
    private String email;
    private int id;

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
}

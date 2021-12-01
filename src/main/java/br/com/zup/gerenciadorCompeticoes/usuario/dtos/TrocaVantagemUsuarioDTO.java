package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;

public class TrocaVantagemUsuarioDTO {

    private String email;
    private String codigoValidador;
    private Vantagem vantagem;


    public TrocaVantagemUsuarioDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigoValidador() {
        return codigoValidador;
    }

    public void setCodigoValidador(String codigoValidador) {
        this.codigoValidador = codigoValidador;
    }

    public Vantagem getVantagem() {
        return vantagem;
    }

    public void setVantagem(Vantagem vantagem) {
        this.vantagem = vantagem;
    }

}

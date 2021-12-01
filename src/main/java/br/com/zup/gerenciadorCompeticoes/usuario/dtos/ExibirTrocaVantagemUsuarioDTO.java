package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

import br.com.zup.gerenciadorCompeticoes.vantagem.dtos.VantagemDTO;

import java.util.List;

public class ExibirTrocaVantagemUsuarioDTO {

    private String email;
    private int pontos;
    private List<VantagemDTO> vantagensAdquiridas;


    public ExibirTrocaVantagemUsuarioDTO() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<VantagemDTO> getVantagensAdquiridas() {
        return vantagensAdquiridas;
    }

    public void setVantagensAdquiridas(List<VantagemDTO> vantagensAdquiridas) {
        this.vantagensAdquiridas = vantagensAdquiridas;
    }

}

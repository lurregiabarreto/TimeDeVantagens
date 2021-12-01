package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;

import java.util.List;

public class ExibirTrocaVantagemUsuarioDTO {

    private String email;
    private int pontosAtualizado;
    private List<Vantagem> vantagensAdquiridas;

    public ExibirTrocaVantagemUsuarioDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPontosAtualizado() {
        return pontosAtualizado;
    }

    public void setPontosAtualizado(int pontosAtualizado) {
        this.pontosAtualizado = pontosAtualizado;
    }

    public List<Vantagem> getVantagensAdquiridas() {
        return vantagensAdquiridas;
    }

    public void setVantagensAdquiridas(List<Vantagem> vantagensAdquiridas) {
        this.vantagensAdquiridas = vantagensAdquiridas;
    }

}

package br.com.zup.gerenciadorCompeticoes.usuario.dtos;
import br.com.zup.gerenciadorCompeticoes.vantagem.dtos.VantagemDTO;

import java.util.List;

public class ExibirTrocaVantagemUsuarioDTO {

    private String email;
    private int pontosAtualizado;
    private List<VantagemDTO> vantagensAdquiridas;

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

    public List<VantagemDTO> getVantagensAdquiridas() {
        return vantagensAdquiridas;
    }

    public void setVantagensAdquiridas(List<VantagemDTO> vantagensAdquiridas) {
        this.vantagensAdquiridas = vantagensAdquiridas;
    }

}

package br.com.zup.gerenciadorCompeticoes.jogo.dtos;

import br.com.zup.gerenciadorCompeticoes.endereco.Endereco;
import br.com.zup.gerenciadorCompeticoes.enuns.Time;

import java.time.LocalDateTime;
import java.util.List;

public class CadastroJogoDTO {

    private Time time1;
    private Time time2;
    private Endereco endereco;
    private LocalDateTime dataDoJogo;
    private List<VantagemDTO> vantagensdto;

    public CadastroJogoDTO() {
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataDoJogo() {
        return dataDoJogo;
    }

    public void setDataDoJogo(LocalDateTime dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public List<VantagemDTO> getVantagensdto() {
        return vantagensdto;
    }

    public void setVantagensdto(List<VantagemDTO> vantagensdto) {
        this.vantagensdto = vantagensdto;
    }
}

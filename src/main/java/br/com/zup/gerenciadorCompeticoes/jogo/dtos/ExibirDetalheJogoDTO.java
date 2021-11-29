package br.com.zup.gerenciadorCompeticoes.jogo.dtos;

import br.com.zup.gerenciadorCompeticoes.endereco.dtos.EnderecoDTO;
import br.com.zup.gerenciadorCompeticoes.enuns.Time;
import br.com.zup.gerenciadorCompeticoes.vantagem.dtos.VantagemDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ExibirDetalheJogoDTO {

    private int id;
    private Time time1;
    private Time time2;
    private EnderecoDTO endereco;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDoJogo;
    private List<VantagemDTO> vantagens;

    public ExibirDetalheJogoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getDataDoJogo() {
        return dataDoJogo;
    }

    public void setDataDoJogo(LocalDateTime dataDoJogo) {
        this.dataDoJogo = dataDoJogo;
    }

    public List<VantagemDTO> getVantagens() {
        return vantagens;
    }

    public void setVantagens(List<VantagemDTO> vantagens) {
        this.vantagens = vantagens;
    }

}

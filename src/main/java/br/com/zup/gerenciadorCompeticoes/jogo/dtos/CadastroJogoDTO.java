package br.com.zup.gerenciadorCompeticoes.jogo.dtos;

import br.com.zup.gerenciadorCompeticoes.endereco.dtos.EnderecoDTO;
import br.com.zup.gerenciadorCompeticoes.enuns.Time;
import br.com.zup.gerenciadorCompeticoes.vantagem.dtos.VantagemDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

public class CadastroJogoDTO {

    @NotNull(message = "Time é obrigatório")
    private Time time1;
    @NotNull(message = "Time é obrigatório")
    private Time time2;
    @Valid
    private EnderecoDTO endereco;
    @NotNull(message = "A data do jogo é obrigatória")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDoJogo;
    @Valid
    private Set<VantagemDTO> vantagens;

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

    public Set<VantagemDTO> getVantagens() {
        return vantagens;
    }

    public void setVantagens(Set<VantagemDTO> vantagens) {
        this.vantagens = vantagens;
    }
}

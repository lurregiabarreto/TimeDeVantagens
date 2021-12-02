package br.com.zup.gerenciadorCompeticoes.vantagem.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class VantagemDTO {

    @NotBlank(message = "Benefício é obrigatório")
    @Size(min = 2, message = "O benefício deve conter no mínimo 2 caracteres")
    private String beneficio;
    @NotNull(message = "Pontos é obrigatório")
    @Range(min = 5, max = 350)
    private int pontos;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataValidade;


    public VantagemDTO() {
    }


    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

}

package br.com.zup.gerenciadorCompeticoes.vantagem.dtos;


import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

public class VantagemDTO {

    @NotBlank(message = "Benefício é obrigatório")
    @Size(min = 2, message = "O benefício deve conter no mínimo 2 caracteres")
    private String beneficio;
    @NotNull(message = "Pontos é obrigatório")
    @Range(min = 5,max = 350)
    private int pontos;

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

}

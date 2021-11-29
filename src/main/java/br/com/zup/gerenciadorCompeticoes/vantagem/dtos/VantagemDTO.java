package br.com.zup.gerenciadorCompeticoes.vantagem.dtos;


public class VantagemDTO {

    private String beneficio;
    private double pontos;

    public VantagemDTO() {
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

}

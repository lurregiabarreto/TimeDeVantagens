package br.com.zup.gerenciadorCompeticoes.vantagem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vantagem")
public class Vantagem {

    @Id
    @Column(nullable = false)
    private String beneficio;
    @Column(nullable = false)
    private double pontos;

    public Vantagem() {
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


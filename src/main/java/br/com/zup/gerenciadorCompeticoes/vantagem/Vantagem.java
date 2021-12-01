package br.com.zup.gerenciadorCompeticoes.vantagem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "vantagens")
public class Vantagem {

    @Id
    private String beneficio;
    @Column(nullable = false)
    private int pontos;
    private LocalDateTime dataValidade;


    public Vantagem() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vantagem vantagem = (Vantagem) o;
        return pontos == vantagem.pontos && Objects.equals(beneficio, vantagem.beneficio) && Objects.equals(dataValidade, vantagem.dataValidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficio, pontos, dataValidade);
    }

}

package br.com.zup.gerenciadorCompeticoes.vantagem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "vantagens")
public class Vantagem {

    @Id
    private String beneficio;
    @Column(nullable = false)
    private int pontos;


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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vantagem vantagem = (Vantagem) o;
        return pontos == vantagem.pontos && Objects.equals(beneficio, vantagem.beneficio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beneficio, pontos);
    }

}

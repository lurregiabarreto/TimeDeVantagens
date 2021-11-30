package br.com.zup.gerenciadorCompeticoes.jogo;

import br.com.zup.gerenciadorCompeticoes.endereco.Endereco;
import br.com.zup.gerenciadorCompeticoes.enuns.Time;
import br.com.zup.gerenciadorCompeticoes.vantagem.Vantagem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private Time time1;
    @Column(nullable = false)
    private Time time2;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Endereco endereco;
    @Column(nullable = false)
    private LocalDateTime dataDoJogo;
    private LocalDateTime dataDeCadastro;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Vantagem> vantagens;

    public Jogo() {
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

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Set<Vantagem> getVantagens() {
        return vantagens;
    }

    public void setVantagens(Set<Vantagem> vantagens) {
        this.vantagens = vantagens;
    }

}

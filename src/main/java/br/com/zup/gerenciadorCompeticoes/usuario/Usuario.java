package br.com.zup.gerenciadorCompeticoes.usuario;

import br.com.zup.gerenciadorCompeticoes.enuns.Time;
import br.com.zup.gerenciadorCompeticoes.voucher.Voucher;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private String email;
    @Column(nullable = false)
    private String nomeUsuario;
    private Time timeCoracao;
    private int pontos;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Voucher> vouchers;


    public Usuario() {
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Time getTimeCoracao() {
        return timeCoracao;
    }

    public void setTimeCoracao(Time timeCoracao) {
        this.timeCoracao = timeCoracao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }

}

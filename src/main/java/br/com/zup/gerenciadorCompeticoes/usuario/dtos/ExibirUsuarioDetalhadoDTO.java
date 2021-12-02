package br.com.zup.gerenciadorCompeticoes.usuario.dtos;

import br.com.zup.gerenciadorCompeticoes.enuns.Time;
import br.com.zup.gerenciadorCompeticoes.voucher.dtos.VoucherDTO;

import java.util.List;

public class ExibirUsuarioDetalhadoDTO {

    private String email;
    private String nomeUsuario;
    private Time timeCoracao;
    private int pontos;
    private List<VoucherDTO> vouchers;


    public ExibirUsuarioDetalhadoDTO() {
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

    public List<VoucherDTO> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<VoucherDTO> vouchers) {
        this.vouchers = vouchers;
    }

}

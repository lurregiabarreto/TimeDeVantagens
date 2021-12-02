package br.com.zup.gerenciadorCompeticoes.voucher;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    private String codigo;
    private String beneficio;
    @Column(nullable = false)
    private LocalDateTime dataValidade;

    public Voucher() {
    }

    public Voucher(String codigo, String beneficio, LocalDateTime dataValidade) {
        this.codigo = codigo;
        this.beneficio = beneficio;
        this.dataValidade = dataValidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(String beneficio) {
        this.beneficio = beneficio;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

}

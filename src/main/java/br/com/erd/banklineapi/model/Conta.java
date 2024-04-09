package br.com.erd.banklineapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@Table(name = "tab_conta")
public class Conta {
    @Column(name = "conta_numero")
    private long numero;

    @Column(name = "conta_saldo")
    private double saldo;

}

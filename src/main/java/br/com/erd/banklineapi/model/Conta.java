package br.com.erd.banklineapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name = "contas")
public class Conta implements Serializable {
    @Serial
    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private long numero;

    @Column(nullable = false)
    private double saldo;

    @OneToOne
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;
}

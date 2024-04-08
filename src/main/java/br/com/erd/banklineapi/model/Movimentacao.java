package br.com.erd.banklineapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {
    @Serial
    private final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    @DateTimeFormat
    private Date dataHora;

    @Column(nullable = false, length = 100)
    private String descricao;

    @Column(nullable = false)
    private double valor;
    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;
}

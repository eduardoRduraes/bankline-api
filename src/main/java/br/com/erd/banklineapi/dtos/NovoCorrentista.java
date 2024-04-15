package br.com.erd.banklineapi.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NovoCorrentista {
    private String cpf;
    private String nome;
}
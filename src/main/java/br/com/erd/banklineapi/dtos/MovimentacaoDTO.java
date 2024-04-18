package br.com.erd.banklineapi.dtos;

import br.com.erd.banklineapi.model.MovimentacaoTipo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovimentacaoDTO {

    private String descricao;

    private double valor;

    private long idConta;

    private MovimentacaoTipo tipo;
}

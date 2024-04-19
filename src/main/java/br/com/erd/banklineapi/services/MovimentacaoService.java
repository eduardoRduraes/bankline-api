package br.com.erd.banklineapi.services;

import br.com.erd.banklineapi.dtos.MovimentacaoDTO;
import br.com.erd.banklineapi.model.Correntista;
import br.com.erd.banklineapi.model.Movimentacao;
import br.com.erd.banklineapi.model.MovimentacaoTipo;
import br.com.erd.banklineapi.repositories.CorrentistaRepository;
import br.com.erd.banklineapi.repositories.MovimentacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MovimentacaoService {
    public final MovimentacaoRepository movimentacaoRepository;
    public final CorrentistaRepository correntistaRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, CorrentistaRepository correntistaRepository){
        this.movimentacaoRepository = movimentacaoRepository;
        this.correntistaRepository = correntistaRepository;
    }

    public Movimentacao create(MovimentacaoDTO data){
        Movimentacao movimentacao = new Movimentacao();
        BeanUtils.copyProperties(data, movimentacao);

        movimentacao.setDataHora(LocalDateTime.now());
        var correntista = this.correntistaRepository.findByConta(movimentacao.getIdConta()).orElse(null);

        if(correntista != null){
            var saldo = correntista.getConta().getSaldo();
            if(movimentacao.getTipo() == MovimentacaoTipo.RECEITA){
                correntista.getConta().setSaldo(saldo + movimentacao.getValor());
            }else{
                correntista.getConta().setSaldo(saldo - movimentacao.getValor());
            }
            return this.movimentacaoRepository.save(movimentacao);
        }
        return null;
    }

    public Movimentacao find(long id){
        var data = this.movimentacaoRepository.findById(id);

        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    public List<Movimentacao> findall(){
        return this.movimentacaoRepository.findAll();
    }
}

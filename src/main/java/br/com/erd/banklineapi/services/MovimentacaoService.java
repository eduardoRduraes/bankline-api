package br.com.erd.banklineapi.services;

import br.com.erd.banklineapi.dtos.MovimentacaoDTO;
import br.com.erd.banklineapi.model.Movimentacao;
import br.com.erd.banklineapi.repositories.MovimentacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class MovimentacaoService {
    public final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository){
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public Movimentacao create(MovimentacaoDTO data){
        Movimentacao movimentacao = new Movimentacao();
        BeanUtils.copyProperties(data, movimentacao);
        movimentacao.setDataHora(LocalDateTime.now());
        return this.movimentacaoRepository.save(movimentacao);
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

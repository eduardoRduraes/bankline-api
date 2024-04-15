package br.com.erd.banklineapi.services;

import br.com.erd.banklineapi.dtos.NovoCorrentista;
import br.com.erd.banklineapi.model.Conta;
import br.com.erd.banklineapi.model.Correntista;
import br.com.erd.banklineapi.repositories.CorrentistaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CorrentistaService {

    public final CorrentistaRepository correntistaRepository;

    public CorrentistaService(CorrentistaRepository correntistaRepository){
        this.correntistaRepository = correntistaRepository;
    }

    public Correntista create(NovoCorrentista data){
        Correntista correntista = new Correntista();

        BeanUtils.copyProperties(data, correntista);
        Conta conta = new Conta();
        conta.setNumero(new Date().getTime());
        conta.setSaldo(0.00);
        correntista.setConta(conta);
        return this.correntistaRepository.save(correntista);
    }

    public Correntista update(long id, Correntista correntista){
        var data = this.correntistaRepository.findById(id);

        if(data.isPresent()){
            return this.correntistaRepository.save(correntista);
        }
        return null;
    }
    public Correntista find(long id){
        var data = this.correntistaRepository.findById(id);

        if(data.isPresent()){
            return data.get();
        }
        return null;
    }

    public List<Correntista> list(){
        return this.correntistaRepository.findAll();
    }
}

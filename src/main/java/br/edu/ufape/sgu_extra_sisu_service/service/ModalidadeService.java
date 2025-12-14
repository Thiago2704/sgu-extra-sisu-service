package br.edu.ufape.sgu_extra_sisu_service.service;

import br.edu.ufape.sgu_extra_sisu_service.model.Modalidade;
import br.edu.ufape.sgu_extra_sisu_service.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModalidadeService {

    @Autowired
    ModalidadeRepository modalidadeRepository;

    public Modalidade create(Modalidade modalidade)
    {
        return modalidadeRepository.save(modalidade);
    }

    public Modalidade update(Long id, Modalidade modalidade){
        Modalidade modExistente = modalidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("modalidade não encontrada"));
        modExistente.setNome(modalidade.getNome());
        modExistente.setDescricao(modalidade.getDescricao());
        return modalidadeRepository.save(modExistente);
    }

    public void delete(Long id){
        modalidadeRepository.findById(id).orElseThrow(() -> new RuntimeException("modalidade não encontrada"));
        modalidadeRepository.deleteById(id);
        return;
    }

    public List<Modalidade> list(){
        return modalidadeRepository.findAll();
    }
}

package br.edu.ufape.sgu_extra_sisu_service.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import com.querydsl.core.types.Predicate;

import br.edu.ufape.sgu_extra_sisu_service.model.EditalExtraSisu;
import br.edu.ufape.sgu_extra_sisu_service.service.interfaces.EditalExtraSisuService;

@Component
public class Fachada {


    @Autowired
    private EditalExtraSisuService extraSisuService;

    public EditalExtraSisu salvarEditalExtraSisu(EditalExtraSisu edital) {
        return extraSisuService.salvar(edital);
    }

    public EditalExtraSisu buscarEditalExtraSisu(Long id) {
        return extraSisuService.buscarPorId(id);
    }

    public Page<EditalExtraSisu> listarEditaisExtraSisu(Predicate filtro, Pageable pageable) {
        return extraSisuService.listarTodos(filtro, pageable);
    }

    public EditalExtraSisu atualizarEditalExtraSisu(Long id, EditalExtraSisu edital) {
        return extraSisuService.atualizar(id, edital);
    }

    public void deletarEditalExtraSisu(Long id) {
        extraSisuService.deletar(id);
    }

}
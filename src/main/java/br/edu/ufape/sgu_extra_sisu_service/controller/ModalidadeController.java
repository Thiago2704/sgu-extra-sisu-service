package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.model.Modalidade;
import br.edu.ufape.sgu_extra_sisu_service.service.ModalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidade")
public class ModalidadeController {

    @Autowired
    ModalidadeService modalidadeService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Modalidade Created(@RequestBody Modalidade modalidade){

        return modalidadeService.create(modalidade);
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.FOUND)
    public List<Modalidade> list(){
        return modalidadeService.list();
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Modalidade update(@PathVariable Long id, @RequestBody Modalidade modalidade){
        return modalidadeService.update(id, modalidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        modalidadeService.delete(id);
        return;
    }


}

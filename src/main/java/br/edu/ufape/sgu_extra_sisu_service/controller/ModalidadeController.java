package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.ModalidadeRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.ModalidadeResponse;
import br.edu.ufape.sgu_extra_sisu_service.model.Modalidade;
import br.edu.ufape.sgu_extra_sisu_service.service.ModalidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/modalidade")
public class ModalidadeController {

    @Autowired
    ModalidadeService modalidadeService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ModalidadeResponse create(@Valid @RequestBody ModalidadeRequest request) {
        Modalidade novaModalidade = request.toModel();
        return new ModalidadeResponse(modalidadeService.create(novaModalidade));
    }

    @GetMapping("/list")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ModalidadeResponse> list() {
        return modalidadeService.list()
                .stream()
                .map(ModalidadeResponse::new)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ModalidadeResponse update(@PathVariable Long id, @Valid @RequestBody ModalidadeRequest request) {
        Modalidade modalidadeAtualizada = request.toModel();
        return new ModalidadeResponse(modalidadeService.update(id, modalidadeAtualizada));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        modalidadeService.delete(id);
    }
}
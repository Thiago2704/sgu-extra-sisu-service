package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.DocumentoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.DocumentoResponse;
import br.edu.ufape.sgu_extra_sisu_service.fachada.Fachada;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private Fachada fachada;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DocumentoResponse salvar(@RequestBody @Valid DocumentoRequest request) {
        return fachada.salvarDocumento(request);
    }

    @PatchMapping("/{id}")
    public DocumentoResponse editar(@PathVariable Long id, @RequestBody DocumentoRequest request) {
        return fachada.editarDocumento(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        fachada.deletarDocumento(id);
    }
}
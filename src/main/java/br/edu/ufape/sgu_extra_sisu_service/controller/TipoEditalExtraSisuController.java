package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.TipoEditalRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.TipoEditalResponse;
import br.edu.ufape.sgu_extra_sisu_service.fachada.Fachada;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipos-editais")
public class TipoEditalExtraSisuController {
    @Autowired
    private Fachada fachada;

    @PostMapping
    public TipoEditalResponse criar(@RequestBody TipoEditalRequest request) {
        return fachada.salvarTipoEdital(request);
    }

    @GetMapping("/{id}")
    public TipoEditalResponse buscarPorId(@PathVariable Long id) {
        return fachada.buscarTipoEdital(id);
    }

    @GetMapping
    public Page<TipoEditalResponse> listar(Pageable pageable) {
        return fachada.listarTiposEditais(pageable);
    }

    @PatchMapping("/{id}")
    public TipoEditalResponse editar(@PathVariable Long id, @RequestBody @Valid TipoEditalRequest request) {
        return fachada.editarTipoEdital(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        fachada.deletarTipoEdital(id);
    }
}
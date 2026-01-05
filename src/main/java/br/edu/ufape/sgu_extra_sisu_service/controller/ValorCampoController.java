package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.ValorCampoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.ValorCampoResponse;
import br.edu.ufape.sgu_extra_sisu_service.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/valor-campo")
@RequiredArgsConstructor
@Tag(name = "Valor Campo", description = "Gerencia as respostas dos campos personalizados")
public class ValorCampoController {

    private final Fachada fachada;

    @PostMapping
    @Operation(summary = "Salvar resposta de campo")
    public ResponseEntity<ValorCampoResponse> salvar(@RequestBody ValorCampoRequest request) {
        return new ResponseEntity<>(fachada.salvarValorCampoExterno(request), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar resposta")
    public ResponseEntity<ValorCampoResponse> editar(@PathVariable Long id, @RequestBody ValorCampoRequest request) {
        return ResponseEntity.ok(fachada.editarValorCampoExterno(id, request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar resposta por ID")
    public ResponseEntity<ValorCampoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fachada.buscarValorCampoExterno(id));
    }

    @GetMapping
    @Operation(summary = "Listar todas as respostas")
    public ResponseEntity<PageResponse<ValorCampoResponse>> listar() {
        return ResponseEntity.ok(fachada.listarValoresCampoExternos());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar resposta")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        fachada.deletarValorCampoExterno(id);
        return ResponseEntity.noContent().build();
    }
}
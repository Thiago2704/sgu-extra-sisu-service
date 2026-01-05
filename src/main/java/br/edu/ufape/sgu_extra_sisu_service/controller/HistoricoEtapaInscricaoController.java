package br.edu.ufape.sgu_extra_sisu_service.controller;

import br.edu.ufape.sgu_extra_sisu_service.controller.response.HistoricoEtapaInscricaoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.fachada.Fachada;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historico-etapa-inscricao")
@RequiredArgsConstructor
@Tag(name = "Histórico de Etapas", description = "Visualiza o histórico de mudanças nas inscrições")
public class HistoricoEtapaInscricaoController {

    private final Fachada fachada;

    @GetMapping("/{id}")
    @Operation(summary = "Buscar registro de histórico por ID")
    public ResponseEntity<HistoricoEtapaInscricaoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(fachada.buscarHistoricoExterno(id));
    }

    @GetMapping
    @Operation(summary = "Listar todos os históricos (Paginado)")
    public ResponseEntity<PageResponse<HistoricoEtapaInscricaoResponse>> listar() {
        return ResponseEntity.ok(fachada.listarHistoricosExternos());
    }
}
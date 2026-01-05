package br.edu.ufape.sgu_extra_sisu_service.service;

import br.edu.ufape.sgu_extra_sisu_service.client.EditaisClient;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.HistoricoEtapaInscricaoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.service.interfaces.HistoricoEtapaInscricaoHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoricoEtapaInscricaoHandlerImpl implements HistoricoEtapaInscricaoHandler {

    private final EditaisClient client;

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackBuscar")
    public HistoricoEtapaInscricaoResponse buscarPorId(Long id) {
        return client.buscarHistoricoPorId(id);
    }

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackListar")
    public PageResponse<HistoricoEtapaInscricaoResponse> listar() {
        return client.listarHistoricos();
    }

    // --- Fallbacks ---

    public HistoricoEtapaInscricaoResponse fallbackBuscar(Long id, Throwable t) {
        log.error("Erro ao buscar histórico ID {}: {}", id, t.getMessage());
        throw new RuntimeException("Histórico indisponível no momento.");
    }

    public PageResponse<HistoricoEtapaInscricaoResponse> fallbackListar(Throwable t) {
        log.error("Erro ao listar históricos: {}", t.getMessage());
        return new PageResponse<>(); 
    }
}
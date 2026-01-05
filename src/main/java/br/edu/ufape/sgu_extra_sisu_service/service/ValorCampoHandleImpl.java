package br.edu.ufape.sgu_extra_sisu_service.service;

import br.edu.ufape.sgu_extra_sisu_service.client.EditaisClient;
import br.edu.ufape.sgu_extra_sisu_service.controller.request.ValorCampoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.ValorCampoResponse;
import br.edu.ufape.sgu_extra_sisu_service.service.interfaces.ValorCampoHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValorCampoHandleImpl implements ValorCampoHandler {

    private final EditaisClient client;

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackSalvar")
    public ValorCampoResponse salvar(ValorCampoRequest request) {
        return client.salvarValorCampo(request);
    }

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackAtualizar")
    public ValorCampoResponse atualizar(Long id, ValorCampoRequest request) {
        return client.atualizarValorCampo(id, request);
    }

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackBuscar")
    public ValorCampoResponse buscarPorId(Long id) {
        return client.buscarValorCampoPorId(id);
    }

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackListar")
    public PageResponse<ValorCampoResponse> listar() {
        return client.listarValoresCampo();
    }

    @Override
    @CircuitBreaker(name = "editaisServiceClient", fallbackMethod = "fallbackDeletar")
    public void deletar(Long id) {
        client.deletarValorCampo(id);
    }

    // --- Fallbacks ---
    
    public ValorCampoResponse fallbackSalvar(ValorCampoRequest request, Throwable t) {
        log.error("Erro ao salvar valor campo: {}", t.getMessage());
        throw new RuntimeException("Serviço indisponível.");
    }
    
    public ValorCampoResponse fallbackAtualizar(Long id, ValorCampoRequest request, Throwable t) {
        log.error("Erro ao atualizar valor campo ID {}: {}", id, t.getMessage());
        throw new RuntimeException("Serviço indisponível.");
    }

    public ValorCampoResponse fallbackBuscar(Long id, Throwable t) {
        log.error("Erro ao buscar valor campo ID {}: {}", id, t.getMessage());
        throw new RuntimeException("Serviço indisponível.");
    }

    public PageResponse<ValorCampoResponse> fallbackListar(Throwable t) {
        log.error("Erro ao listar valores: {}", t.getMessage());
        return new PageResponse<>(); 
    }

    public void fallbackDeletar(Long id, Throwable t) {
        log.error("Erro ao deletar valor campo ID {}: {}", id, t.getMessage());
        throw new RuntimeException("Serviço indisponível.");
    }
}

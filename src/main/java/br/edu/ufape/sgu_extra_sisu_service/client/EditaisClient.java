package br.edu.ufape.sgu_extra_sisu_service.client;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.InscricaoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.HistoricoEtapaInscricaoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.InscricaoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.StatusPersonalizadoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.ValorCampoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.request.StatusInscricaoPatchRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.request.StatusPersonalizadoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.request.ValorCampoRequest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.sgu_extra_sisu_service.config.FeignClientConfig;



import java.util.List;

@FeignClient(name = "sgu-editais-service", configuration = FeignClientConfig.class)
public interface EditaisClient {

    // ================== Inscrição ==================

    @PostMapping("/inscricao")
    InscricaoResponse salvarInscricao(@RequestBody InscricaoRequest request);

    @GetMapping("/inscricao/{id}")
    InscricaoResponse buscarPorIdInscricao(@PathVariable("id") Long id);

    @GetMapping("/inscricao/atual")
    List<InscricaoResponse> listarMinhasInscricoes();

    @PatchMapping("/inscricao/{id}/status")
    InscricaoResponse atualizarStatusInscricao(
            @PathVariable("id") Long id, 
            @RequestBody StatusInscricaoPatchRequest request
    );

    @DeleteMapping("/inscricao/{id}")
    void deletarInscricao(@PathVariable("id") Long id);

    // ================== Status personalizado ==================

    @GetMapping("/status-personalizado")
    List<StatusPersonalizadoResponse> listarStatusPersonalizados();

    @GetMapping("/status-personalizado/{id}")
    StatusPersonalizadoResponse buscarStatusPersonalizadoPorId(@PathVariable("id") Long id);

    @PostMapping("/status-personalizado")
    StatusPersonalizadoResponse criarStatusPersonalizado(@RequestBody StatusPersonalizadoRequest request);

    @PatchMapping("/status-personalizado/{id}")
    StatusPersonalizadoResponse atualizarStatusPersonalizado(@PathVariable("id") Long id, @RequestBody StatusPersonalizadoRequest request);

    // ================== Valor campo ==================

    @PostMapping("/valor-campo")
    ValorCampoResponse salvarValorCampo(@RequestBody ValorCampoRequest request);

    @PatchMapping("/valor-campo/{id}")
    ValorCampoResponse atualizarValorCampo(@PathVariable("id") Long id, @RequestBody ValorCampoRequest request);

    @GetMapping("/valor-campo/{id}")
    ValorCampoResponse buscarValorCampoPorId(@PathVariable("id") Long id);

    @GetMapping("/valor-campo")
    PageResponse<ValorCampoResponse> listarValoresCampo(); 

    @DeleteMapping("/valor-campo/{id}")
    void deletarValorCampo(@PathVariable("id") Long id);

    // ================== Histórico etapa inscrição ==================

    @GetMapping("/historico-etapa-inscricao/{id}")
    HistoricoEtapaInscricaoResponse buscarHistoricoPorId(@PathVariable("id") Long id);

    @GetMapping("/historico-etapa-inscricao")
    PageResponse<HistoricoEtapaInscricaoResponse> listarHistoricos();
}

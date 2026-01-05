package br.edu.ufape.sgu_extra_sisu_service.service.interfaces;

import br.edu.ufape.sgu_extra_sisu_service.controller.response.HistoricoEtapaInscricaoResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;

public interface HistoricoEtapaInscricaoHandler {
    HistoricoEtapaInscricaoResponse buscarPorId(Long id);
    PageResponse<HistoricoEtapaInscricaoResponse> listar();
}
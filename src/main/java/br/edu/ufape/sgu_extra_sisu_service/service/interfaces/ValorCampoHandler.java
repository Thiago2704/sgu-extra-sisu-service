package br.edu.ufape.sgu_extra_sisu_service.service.interfaces;

import br.edu.ufape.sgu_extra_sisu_service.controller.request.ValorCampoRequest;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.PageResponse;
import br.edu.ufape.sgu_extra_sisu_service.controller.response.ValorCampoResponse;

public interface ValorCampoHandler {
    ValorCampoResponse salvar(ValorCampoRequest request);
    ValorCampoResponse atualizar(Long id, ValorCampoRequest request);
    ValorCampoResponse buscarPorId(Long id);
    PageResponse<ValorCampoResponse> listar();
    void deletar(Long id);
}

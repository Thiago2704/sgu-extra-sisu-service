package br.edu.ufape.sgu_extra_sisu_service.controller.response;

import br.edu.ufape.sgu_extra_sisu_service.model.Modalidade;
import org.modelmapper.ModelMapper;
import lombok.Data;

@Data
public class ModalidadeResponse {
    private Long id;
    private String nome;
    private String descricao;

    public ModalidadeResponse(Modalidade obj) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(obj, this);
    }
}
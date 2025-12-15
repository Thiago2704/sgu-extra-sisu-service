package br.edu.ufape.sgu_extra_sisu_service.controller.request;

import br.edu.ufape.sgu_extra_sisu_service.model.Modalidade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ModalidadeRequest {

    @NotBlank(message = "O nome da modalidade é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "A descricao é obrigatória")
    @Size(max = 1000, message = "A descricao deve ter no máximo 1000 caracteres")
    private String descricao;

    // Adicione outros campos aqui se necessário (ex: descrição, código)

    public Modalidade toModel() {
        Modalidade modalidade = new Modalidade();
        modalidade.setNome(this.nome);
        modalidade.setDescricao(this.descricao);
        return modalidade;
    }
}
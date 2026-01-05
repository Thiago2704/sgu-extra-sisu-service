package br.edu.ufape.sgu_extra_sisu_service.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentoRequest {
    @NotBlank(message = "nome é obrigatório")
    private String nome;

    @NotBlank(message = "caminho é obrigatório")
    private String caminho;
    private LocalDateTime dataUpload;
    private Long etapaId;
    private Long inscricaoId;
}
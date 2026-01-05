package br.edu.ufape.sgu_extra_sisu_service.controller.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DocumentoResponse {
    private Long id;
    private String nome;
    private String caminho;
    private LocalDateTime dataUpload;
    private Long etapaId;
}
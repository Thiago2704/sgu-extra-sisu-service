package br.edu.ufape.sgu_extra_sisu_service.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class HistoricoEtapaInscricaoResponse {
    private Long id;
    private String observacao;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAcao;

    private EtapaResponse etapa;
    private InscricaoResponse inscricao; 
    private StatusPersonalizadoResponse status;
}

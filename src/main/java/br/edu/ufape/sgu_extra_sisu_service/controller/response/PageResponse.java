package br.edu.ufape.sgu_extra_sisu_service.controller.response;

import lombok.Data;
import java.util.List;

@Data
public class PageResponse<T> {
    private List<T> content;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
}

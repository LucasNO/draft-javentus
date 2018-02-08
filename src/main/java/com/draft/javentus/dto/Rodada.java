package com.draft.javentus.dto;

import com.draft.javentus.model.Confronto;
import java.util.List;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
public class Rodada {
    
    private List<Confronto> confrontos;
    
    private Integer qtdJogosPorRodada;
    
}

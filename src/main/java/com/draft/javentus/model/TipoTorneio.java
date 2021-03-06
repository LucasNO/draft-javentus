package com.draft.javentus.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 *
 * @author lucas
 */

@Data
@Entity
@Table(name = "tto_tipo_torneio")
public class TipoTorneio implements Serializable {

    private static final long serialVersionUID = -4894712311539502309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tto_id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tto_descricao")
    private String descricao;
}

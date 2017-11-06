package com.draft.javentus.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "jog_jogador")
@Data
public class Jogador implements Serializable {

    private static final long serialVersionUID = -5599547776943080616L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jog_id")
    private Integer id;
    
    @NotNull
    @Column(name = "jog_nome")
    private String nome;
    
    @JoinColumn(name = "pos_id", referencedColumnName = "pos_id")
    @ManyToOne
    private Posicao pos;
    
    @JoinColumn(name = "tim_id", referencedColumnName = "tim_id")
    @ManyToOne
    private Time tim;
}

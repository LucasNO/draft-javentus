package com.draft.javentus.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "pos_posicao")
@Data
public class Posicao implements Serializable {

    private static final long serialVersionUID = 4685306095004303876L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pos_id")
    private Integer id;

    @NotNull
    @Column(name = "pos_descricao")
    private String descricao;
    
//    @OneToMany(mappedBy = "pos")
//    private List<Jogador> jogadorList;
}

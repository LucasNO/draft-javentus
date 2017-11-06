package com.draft.javentus.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tim_time")
@Data
public class Time implements Serializable {

    private static final long serialVersionUID = 45684876633796937L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tim_id")
    private Integer id;

    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario usr;

    @Column(name = "tim_nome")
    private String nome;

    @OneToMany(mappedBy = "tim")
    private List<Jogador> jogadorList;
}

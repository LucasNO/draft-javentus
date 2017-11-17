/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.draft.javentus.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Data
@Entity
@Table(name = "tit_titulos")
public class Titulos implements Serializable {

    private static final long serialVersionUID = -5486391756401678264L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tit_id")
    private Integer id;
    
    @Column(name = "tit_primeiro")
    private Integer primeiro;
    
    @Column(name = "tit_segundo")
    private Integer segundo;
    
    @Column(name = "tit_terceiro")
    private Integer terceiro;
    
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private Usuario usuario;
}

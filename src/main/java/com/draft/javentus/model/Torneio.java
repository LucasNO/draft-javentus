package com.draft.javentus.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tor_torneio")
@Data
public class Torneio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tor_id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tor_data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tor_ativo")
    private short ativo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tor_anoFifa")
    private int anoFifa;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torId")
//    private List<HistoricoConfrontos> historicoConfrontosList;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "torId")
//    private List<HistoricoTorneio> historicoTorneioList;
}

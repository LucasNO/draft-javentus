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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "htr_historico_torneio")
@Data
public class HistoricoTorneio implements Serializable {

    private static final long serialVersionUID = -7341607219472051989L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "htr_id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "htr_posicao")
    private int posicao;
    @Column(name = "htr_pontos")
    private Integer pontos;
    @Column(name = "htr_jogos")
    private Integer jogos;
    @Column(name = "htr_vitorias")
    private Integer vitorias;
    @Column(name = "htr_empates")
    private Integer empates;
    @Column(name = "htr_derrotas")
    private Integer derrotas;
    @Column(name = "htr_gols_pro")
    private Integer golsPro;
    @Column(name = "htr_gols_contra")
    private Integer golsContra;
    @Column(name = "htr_saldo_gols")
    private Integer saldoGols;
    @JoinColumn(name = "tim_id", referencedColumnName = "tim_id")
    @ManyToOne
    private Time time;
    @JoinColumn(name = "tor_id", referencedColumnName = "tor_id")
    @ManyToOne(optional = false)
    private Torneio torneio;
}

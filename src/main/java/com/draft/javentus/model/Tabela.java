package com.draft.javentus.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "tab_tabela")
@Data
public class Tabela implements Serializable {

    private static final long serialVersionUID = -3722583305877265598L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tab_id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tim_id")
    private int time;
    @Column(name = "tab_pontos")
    private Integer pontos;
    @Column(name = "tab_jogos")
    private Integer jogos;
    @Column(name = "tab_vitorias")
    private Integer vitorias;
    @Column(name = "tab_empates")
    private Integer empates;
    @Column(name = "tab_derrotas")
    private Integer derrotas;
    @Column(name = "tab_gols_pro")
    private Integer golsPro;
    @Column(name = "tab_gols_contra")
    private Integer golsContra;
    @Column(name = "tab_saldo_gols")
    private Integer saldoGols;
}

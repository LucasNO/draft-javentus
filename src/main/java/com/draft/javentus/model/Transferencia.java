package com.draft.javentus.model;

import java.io.Serializable;
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
@Entity
@Table(name = "tra_transferencia")
@Data
public class Transferencia implements Serializable {

    private static final long serialVersionUID = 1416499035582475948L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Time time1;
    
    @JoinColumn(name = "hic_time2", referencedColumnName = "tim_id")
    @ManyToOne(optional = false)
    private Time time2;
    
    @JoinColumn(name = "jog_jogador1", referencedColumnName = "jog_id")
    @ManyToOne(optional = false)
    private Jogador jogador1;
    
    @JoinColumn(name = "jog_jogador2", referencedColumnName = "jog_id")
    @ManyToOne(optional = false)
    private Jogador jogador2;
}

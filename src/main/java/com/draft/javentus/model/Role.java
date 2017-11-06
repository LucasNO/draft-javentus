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
import lombok.Data;

/**
 *
 * @author lucas
 */

@Entity
@Table(name = "rol_role")
@Data
public class Role implements Serializable{

    private static final long serialVersionUID = -8585559801198115385L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rol_id")
    private int id;
    @Column(name = "rol_role")
    private String role;
}

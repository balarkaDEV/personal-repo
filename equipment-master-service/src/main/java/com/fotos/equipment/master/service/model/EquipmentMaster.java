package com.fotos.equipment.master.service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "equipment_master")
public class EquipmentMaster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="make")
    private String make;

    @Column(name="entry_date")
    private Date entryDate;

    @Column(name="photographer_id")
    private long photographerId;
}

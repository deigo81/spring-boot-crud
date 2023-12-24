package com.codesnippet.springbootcrudh2.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Data
@Entity
@Table(name="COM_ENTITIES")
public class ComEntity implements Serializable
{
    private static final long serialVersionUID = 6591906819531881172L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "code",nullable = false)
    private String code;



    @Column(name = "description",nullable = false)
    private String description;

    public ComEntity() {
        super();
    }

    public ComEntity(Long id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }


}

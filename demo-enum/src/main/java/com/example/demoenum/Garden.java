package com.example.demoenum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Garden {
    @Id @GeneratedValue
    private Long id;

    private String name;
}

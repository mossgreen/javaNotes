package com.example.emnudemo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
public class Flower {
    @Id
    private int id;

    private Season season;
}

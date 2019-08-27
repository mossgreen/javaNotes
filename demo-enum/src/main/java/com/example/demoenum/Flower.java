package com.example.demoenum;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Flower {

    @Id
    private Long id;

    private Season season;
}

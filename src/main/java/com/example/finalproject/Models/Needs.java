package com.example.finalproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity
public class Needs {
    @Id
    private Integer id;
    private Double mass;
    private Double calories;
    private Double carbohydrates;
    private Double protein;
    private Double fat;
    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    private Requirements requirements;

    @ManyToOne
    private Dite dite;

}

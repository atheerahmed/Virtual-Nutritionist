package com.example.finalproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Dite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String breakfast;
    @NotEmpty
    private String snack1;
    @NotEmpty
    private String lunch;
    @NotEmpty
    private String snack2;
    @NotEmpty
    private String dinner;

    private Double calories;

    @OneToMany(mappedBy = "dite")
    @JsonIgnore
    private Set<Needs> results;
}

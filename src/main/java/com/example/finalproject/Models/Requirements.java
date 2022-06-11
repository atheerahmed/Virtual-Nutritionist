package com.example.finalproject.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class Requirements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "Age can't be null ")
    private Integer age;
    @NotEmpty(message = "Gender can't be null ")
    @Pattern(regexp = "(male|female)",message = "Gender must male or female")
    private String gender;
    @NotNull(message = "Height can't be null ")
    private Double height;
    @NotNull(message = "Wight can't be null ")
    private Double weight;
    @NotEmpty
    @Pattern(regexp="(Active|Not Active|Very Active)")
    private String active;
    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    private MyUsers myusers;

    @OneToOne(mappedBy = "requirements",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Needs needs;



}

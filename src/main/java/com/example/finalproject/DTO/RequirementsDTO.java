package com.example.finalproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class RequirementsDTO {
    private Integer userId;
    private Integer age;
    private String gender;
    private Double height;
    private Double weight;
    private String active;
}

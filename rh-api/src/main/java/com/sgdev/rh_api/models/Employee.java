package com.sgdev.rh_api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor

@ToString

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmployee;
    String name;
    String departament;
    Double salary;

}

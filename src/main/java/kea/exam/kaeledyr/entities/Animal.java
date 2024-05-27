package kea.exam.kaeledyr.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToOne
//    private List<String> nickNames;
    private AnimalType animalType;
    private String birthdate;
    private boolean star;
    private double cutenessFactor;

    public Animal(String name, AnimalType animalType, String birthdate, boolean star, double cutenessFactor) {
        this.name = name;
        this.animalType = animalType;
        this.birthdate = birthdate;
        this.star = star;
        this.cutenessFactor = cutenessFactor;
    }



}

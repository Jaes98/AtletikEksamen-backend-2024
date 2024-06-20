package kea.exam.atletikEksamen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String resultType;

    @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Result> results;

    @ManyToMany(mappedBy = "disciplines")
    @ToString.Exclude
    private Set<Participant> participants;

    public Discipline(String name, String resultType) {
        this.name = name;
        this.resultType = resultType;
    }

}

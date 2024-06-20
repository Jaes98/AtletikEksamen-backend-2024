package kea.exam.atletikEksamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String gender;
    private int age;
    private String club;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("participant")
    private List<Result> results;


    @ManyToMany
    @JoinTable(
            name = "participant_discipline",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "discipline_id")
    )
    private List<Discipline> disciplines;

    public Participant(String name, String gender, int age, String club, List<Result> results, List<Discipline> disciplines) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.club = club;
        this.results = results;
        this.disciplines = disciplines;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name=" + name +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", club='" + club + '\'' +
                ", results='" + results + '\'' +
                ", disciplines=" + disciplines +
                '}';
    }
}

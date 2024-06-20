package kea.exam.atletikEksamen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
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

    @OneToMany(mappedBy = "discipline")
    private List<Result> results;
    @ManyToMany(mappedBy = "disciplines")
    private List<Participant> participants;

    public Discipline(String name, String resultType, List<Result> results, List<Participant> participants) {
        this.name = name;
        this.resultType = resultType;
        this.results = results;
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "name=" + name +
                ", resultType='" + resultType + '\'' +
                ", results='" + results + '\'' +
                ", participants=" + participants +
                '}';
    }

}

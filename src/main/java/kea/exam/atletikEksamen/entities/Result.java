package kea.exam.atletikEksamen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String resultType;
    private String date;
//    private String resultValue;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    @ToString.Exclude
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "discipline_id", nullable = false)
    @ToString.Exclude
    private Discipline discipline;

    public Result(String resultType, String date) {
        this.resultType = resultType;
        this.date = date;
    }

}

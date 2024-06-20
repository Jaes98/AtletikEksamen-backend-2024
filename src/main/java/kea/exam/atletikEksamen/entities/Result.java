package kea.exam.atletikEksamen.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String resultType;
    private java.time.LocalDate date;
//    private String resultValue;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Result(String resultType, LocalDate date, Participant participant, Discipline discipline) {
        this.resultType = resultType;
        this.date = date;
        this.participant = participant;
        this.discipline = discipline;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultType=" + resultType +
                ", date='" + date + '\'' +
                ", participant='" + participant + '\'' +
                ", discipline='" + discipline +
                '}';
    }

}

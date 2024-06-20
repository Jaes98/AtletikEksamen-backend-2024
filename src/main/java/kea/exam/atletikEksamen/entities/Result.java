package kea.exam.atletikEksamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    @JsonIgnoreProperties("results")
    private Participant participant;

    public Result(String resultType, LocalDate date, Discipline discipline, Participant participant) {
        this.resultType = resultType;
        this.date = date;
        this.discipline = discipline;
        this.participant = participant;
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

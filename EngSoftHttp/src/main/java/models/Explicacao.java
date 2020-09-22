package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor

public class Explicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalTime inicio;
    private LocalTime fim;
    private DayOfWeek dia;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Cadeira cadeira;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference(value = "aluno-explicacao")
    private Aluno aluno;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference(value = "explicador-explicacao")
    private Explicador explicador;

    public Explicacao(LocalTime inicio, LocalTime end){
        this.inicio = inicio;
        this.fim =end;
    }

    public Explicacao(Explicador explicador) {
        this.explicador=explicador;
    }
/*
    public boolean overlaps(Explicacao other) {
        return this.isBetween(other) || other.isBetween(this) ||
                (this.inicio.equals(other.inicio) && this.fim.equals(other.fim));
    }

 */

    private boolean isBetween(Explicacao other){
        LocalTime appointmentStartTime=other.getInicio();
        LocalTime appointmentEndTime=other.getFim();
        return this.isBetween(appointmentStartTime) || this.isBetween(appointmentEndTime);
    }
    private boolean isBetween(LocalTime timeToCheck){
        return this.inicio.isBefore(timeToCheck) && this.fim.isAfter(timeToCheck);
    }

}

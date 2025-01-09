package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Ordre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdre;

    private Integer volume;
    private LocalDate dateCreation;
    private LocalDate dateExecution;
    private float montant;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @Enumerated(EnumType.STRING)
    private TypeOrdre typeOrdre;

    @ManyToOne
    @JoinColumn(name = "portefeuille_id")
    private Portefeuille portefeuille;

    @ManyToOne
    @JoinColumn(name = "action_id", nullable = false)
    private Action action;

}

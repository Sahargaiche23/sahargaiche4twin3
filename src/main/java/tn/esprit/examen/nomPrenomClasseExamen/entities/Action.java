package tn.esprit.examen.nomPrenomClasseExamen.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAction;

    private float prixAchatActuel;
    private float prixVenteActuel;
    private Integer volume;
    private LocalDate dateEmission;

    @Column(unique = true, nullable = false)
    private String symbole;
    @OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
    private List<Ordre> ordres;
}

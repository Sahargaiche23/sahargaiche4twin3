package tn.esprit.examen.nomPrenomClasseExamen.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Portefeuille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPortefeuille;

    @Column(unique = true, nullable = false)
    private Integer reference;

    private float solde;

    @OneToMany(mappedBy = "portefeuille", cascade = CascadeType.ALL)
    private List<Ordre> ordres;

    @OneToMany(mappedBy = "portefeuille", cascade = CascadeType.ALL)
    private List<ElementPortefeuille> elements;

}
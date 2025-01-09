package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
public class ElementPortefeuille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idElement;

    private String symbole;
    private Integer nombreActions;
    private float prixAchat;

    @ManyToOne
    @JoinColumn(name = "portefeuille_id")
    private Portefeuille portefeuille;
}
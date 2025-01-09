package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Ordre;

import java.time.LocalDate;
import java.util.List;

public interface OrdreService {
    void addOrdreAndAffectToActionAndPortefeuille(Ordre ordre, String symbole, Integer reference);

    List<String> listSymbolesActionsParPortefeuilleEtDateEmission(Integer referencePortefeuille, LocalDate startDate, LocalDate endDate);
}
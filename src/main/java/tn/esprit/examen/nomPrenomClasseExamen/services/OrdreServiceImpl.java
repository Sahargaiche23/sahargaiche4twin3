package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Action;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Ordre;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Statut;
import tn.esprit.examen.nomPrenomClasseExamen.entities.TypeOrdre;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.OrdreRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrdreServiceImpl implements OrdreService {

    @Autowired
    private OrdreRepository ordreRepository;


    @Override
    public void addOrdreAndAffectToActionAndPortefeuille(Ordre ordre, String symbole, Integer reference) {
        float montant = 0;

        Action action = ordre.getAction();
        if (action == null) {
            throw new IllegalArgumentException("L'action associée à cet ordre est introuvable.");
        }


        if (TypeOrdre.ACHAT.equals(ordre.getTypeOrdre())) {
            montant = ordre.getVolume() * action.getPrixAchatActuel();
        } else if (TypeOrdre.VENTE.equals(ordre.getTypeOrdre())) {
            montant = ordre.getVolume() * action.getPrixVenteActuel();
        }

        ordre.setMontant(montant);
        ordre.setStatut(Statut.EN_ATTENTE);
        ordre.setDateCreation(LocalDate.now());
        ordreRepository.save(ordre);
    }

    @Override
    public List<String> listSymbolesActionsParPortefeuilleEtDateEmission(Integer referencePortefeuille, LocalDate startDate, LocalDate endDate) {
        return ordreRepository.findSymbolsByPortefeuilleAndDateRange(referencePortefeuille, startDate, endDate);
    }
}




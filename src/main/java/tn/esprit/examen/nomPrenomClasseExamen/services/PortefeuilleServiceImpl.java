package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Portefeuille;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.PortefeuilleRepository;

@Service
public class PortefeuilleServiceImpl implements PortefeuilleService {

    @Autowired
    private PortefeuilleRepository portefeuilleRepository;

    @Override
    public Portefeuille addPortefeuilleWithElements(Portefeuille portefeuille) {
        // Relier les éléments au portefeuille
        portefeuille.getElements().forEach(element -> element.setPortefeuille(portefeuille));
        return portefeuilleRepository.save(portefeuille);
    }
}
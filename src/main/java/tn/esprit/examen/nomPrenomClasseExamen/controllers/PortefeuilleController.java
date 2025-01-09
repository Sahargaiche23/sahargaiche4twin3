package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Portefeuille;
import tn.esprit.examen.nomPrenomClasseExamen.services.PortefeuilleService;

@RestController
@RequestMapping("/api/portefeuilles")
public class PortefeuilleController {

    @Autowired
    private PortefeuilleService portefeuilleService;

    @PostMapping("/addWithElements")
    public Portefeuille addPortefeuilleWithElements(@RequestBody Portefeuille portefeuille) {
        return portefeuilleService.addPortefeuilleWithElements(portefeuille);
    }
}

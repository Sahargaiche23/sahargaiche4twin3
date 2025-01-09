package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Ordre;
import tn.esprit.examen.nomPrenomClasseExamen.services.OrdreService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/ordres")
public class OrdreController {

    @Autowired
    private OrdreService ordreService;

    @PostMapping("/add")
    public ResponseEntity<String> addOrdre(@RequestBody Ordre ordre, @RequestParam String symbole, @RequestParam Integer reference) {
        ordreService.addOrdreAndAffectToActionAndPortefeuille(ordre, symbole, reference);
        return ResponseEntity.ok("Ordre ajouté avec succès.");
    }

    @GetMapping("/symbols")
    public ResponseEntity<List<String>> getSymbolsByPortefeuilleAndDateRange(
            @RequestParam Integer referencePortefeuille,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        List<String> symbols = ordreService.listSymbolesActionsParPortefeuilleEtDateEmission(referencePortefeuille, startDate, endDate);
        return ResponseEntity.ok(symbols);
    }
}

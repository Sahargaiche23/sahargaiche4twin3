package tn.esprit.examen.nomPrenomClasseExamen.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Action;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.ActionRepository;

import java.util.List;

@Service
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionRepository actionRepository;



    @Override
    public List<Action> addActions(List<Action> listActions) {
        return actionRepository.saveAll(listActions);
    }
}

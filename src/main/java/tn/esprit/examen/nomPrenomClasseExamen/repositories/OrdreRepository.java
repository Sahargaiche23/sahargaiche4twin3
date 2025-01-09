package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Ordre;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdreRepository extends JpaRepository<Ordre, Integer> {

    @Query("SELECT o.action.symbole FROM Ordre o WHERE o.portefeuille.idPortefeuille = :referencePortefeuille AND o.dateCreation BETWEEN :startDate AND :endDate")
    List<String> findSymbolsByPortefeuilleAndDateRange(@Param("referencePortefeuille") Integer referencePortefeuille,
                                                       @Param("startDate") LocalDate startDate,
                                                       @Param("endDate") LocalDate endDate);
    @Query("SELECT o FROM Ordre o WHERE o.statut = 'EN_ATTENTE'")
    List<Ordre> findPendingOrders();

    @Modifying
    @Transactional
    @Query("UPDATE Ordre o SET o.statut = :statut, o.dateExecution = :dateExecution WHERE o.id = :id")
    void updateOrderStatus(@Param("id") Integer id, @Param("statut") String statut, @Param("dateExecution") LocalDate dateExecution);


}


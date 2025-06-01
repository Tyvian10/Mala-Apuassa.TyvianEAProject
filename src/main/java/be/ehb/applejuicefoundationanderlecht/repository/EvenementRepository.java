package be.ehb.applejuicefoundationanderlecht.repository;

import be.ehb.applejuicefoundationanderlecht.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
    List<Evenement> findTop10ByOrderByTijdstipDesc();
}
//interface, methodes worden gedefiniert om samen te kunnen werken met de database
//ik erf methodes van de database
//long = primary key

//geef een lijst van 10 nieuwe resultaten
package com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.repositories;

import com.anderlecht.ngo.Entreprise_Apps_Hisham_Boussof.models.Evenement;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EvenementRepository extends CrudRepository<Evenement, Long> {
    List<Evenement> vindTop10OrderByTijdstipDesc();
}

package com.javachinna.repo;

import com.javachinna.model.Contrat;
import com.javachinna.model.CountType;
import com.javachinna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratRepo extends JpaRepository<Contrat,Long> {

    List<Contrat> findContratByUserId(Long n);

    @Query(value = "SELECT new com.javachinna.model.CountType(count(*)/(SELECT COUNT(*) FROM Contrat)*100,c.branche)FROM Contrat c GROUP BY c.branche")
    public List<CountType> getPercentageGroupByBranche();

    /*@Query("SELECT p.id, COUNT(c) FROM Contrat c JOIN c.produit p GROUP BY p.id")
    List<Object[]> countContratByProduit();*/

    @Query("SELECT p.Nom, COUNT(c) FROM Contrat c JOIN c.produit p GROUP BY p.Nom")
    List<Object[]> countContratByProduit();

}

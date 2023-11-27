package com.poly.gestioncatalogueg1.dao;

import com.poly.gestioncatalogueg1.entities.Categorie;
import com.poly.gestioncatalogueg1.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends JpaRepository<Categorie,Long> {
    @Query("Select c from Categorie c where c.id= :x")
    public List<Categorie> getCategorieBYCat(@Param("x") Long idC);
}

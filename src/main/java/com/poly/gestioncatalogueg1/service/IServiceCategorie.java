package com.poly.gestioncatalogueg1.service;

import com.poly.gestioncatalogueg1.entities.Categorie;
import com.poly.gestioncatalogueg1.entities.Produit;

import java.util.List;

public interface IServiceCategorie {
    public void saveCategorie(Categorie c);
    public List<Categorie> getAllCategories();
    public List<Categorie> getCategoriesBId(Long idC);
    public void deleteCategorie(Long idC);
}

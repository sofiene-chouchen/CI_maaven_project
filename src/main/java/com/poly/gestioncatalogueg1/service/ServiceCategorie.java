package com.poly.gestioncatalogueg1.service;

import com.poly.gestioncatalogueg1.dao.CategorieRepository;
import com.poly.gestioncatalogueg1.entities.Categorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie {
  CategorieRepository categorieRepository;

  @Override
  public void saveCategorie(Categorie c) {
    categorieRepository.save(c);
  }

  @Override
  public List<Categorie> getAllCategories() {
    return categorieRepository.findAll();
  }

  @Override
  public List<Categorie> getCategoriesBId(Long idC) {
    return categorieRepository.getCategorieBYCat(idC);
  }


  @Override
  public void deleteCategorie(Long id) {
    categorieRepository.deleteById(id);
  }
}

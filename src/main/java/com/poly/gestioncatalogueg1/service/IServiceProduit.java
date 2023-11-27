package com.poly.gestioncatalogueg1.service;

import com.poly.gestioncatalogueg1.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceProduit {
  public void saveProduct(Produit p);

  public List<Produit> getAllProducts();

  public Page<Produit> getProductsByMC(String mc, Pageable p);

  public List<Produit> getProductsBCat(Long idCat);

  public void deleteProduct(Long id);

  public Produit getProduct(Long id);

  public Produit updateProduct(Long id, Produit p);
}

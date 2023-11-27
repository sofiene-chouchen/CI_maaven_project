package com.poly.gestioncatalogueg1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Categorie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String nom;
  @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
  // categorie esclave de produit lautre extrimitee est le master
  List<Produit> produits;

}

package com.poly.gestioncatalogueg1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity

public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pour faire l auto increment
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 20)
    private String nom;
    private double prix;
    @Min(0)
    private int quantite;

    @ManyToOne
    @NotNull(message = "la categorie ne peut pas etre null")
    private Categorie categorie;
}

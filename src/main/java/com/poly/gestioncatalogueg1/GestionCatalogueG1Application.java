package com.poly.gestioncatalogueg1;

import com.poly.gestioncatalogueg1.dao.CategorieRepository;
import com.poly.gestioncatalogueg1.dao.ProduitRepository;
import com.poly.gestioncatalogueg1.entities.Categorie;
import com.poly.gestioncatalogueg1.entities.Produit;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class GestionCatalogueG1Application implements CommandLineRunner {
   /*@Autowired
    ProduitRepository produitRepository;
    @Autowired
    CategorieRepository categorieRepository;*/
    private CategorieRepository categorieRepository;
    private ProduitRepository produitRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionCatalogueG1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    //categorieRepository.save(new Categorie(null,"informatique",null));
    //produitRepository.save(new Produit(null,"pc portable",3000,5,categorieRepository.findById(1L).get()));

    }
    @Bean  //execution de cette fonction lors demarage spring
    CommandLineRunner commandLineRunner(CategorieRepository categorieRepository,ProduitRepository produitRepository){
        return args->{
//            categorieRepository.save(new Categorie(null,"informatique",null));
//            produitRepository.save(new Produit(null," telephone",3000,5,categorieRepository.findById(1L).get()));
//            categorieRepository.save(Categorie.builder().nom("Smartwatch").build());
//            produitRepository.getProductsBYCat(1L);
        };
    }
}

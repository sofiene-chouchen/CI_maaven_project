package com.poly.gestioncatalogueg1.controleur;

import com.poly.gestioncatalogueg1.entities.Categorie;
import com.poly.gestioncatalogueg1.entities.Produit;
import com.poly.gestioncatalogueg1.service.ServiceCategorie;
import com.poly.gestioncatalogueg1.service.ServiceProduit;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //api on utilise RestController
@AllArgsConstructor
public class ControleurProduit {
  ServiceProduit serviceProduit;
  ServiceCategorie serviceCategorie;
  @GetMapping("/index")
  public String getAllProducts(@RequestParam(name = "mc", defaultValue = "") String mc,
                               @RequestParam(name = "size", defaultValue = "7" ) int size,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               Model m){
/*
        List<Product> liste= productService.getAllProducts();
*/
    m.addAttribute("mc",mc);
    Page<Produit> liste= serviceProduit.getProductsByMC(mc, PageRequest.of(page,size));
    m.addAttribute("product",liste.getContent());
    m.addAttribute("pages", new int[liste.getTotalPages()]);
    m.addAttribute("currentPage", liste.getNumber());
    return "vue";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable Long id) {
    serviceProduit.deleteProduct(id);
    return "redirect:/index";
  }


  @GetMapping("/formajout")
  public String addProduct( Model m) {

    m.addAttribute("categories", serviceCategorie.getAllCategories());
    return "form";
  }

  @PostMapping("/addProduct")
  public String addProduct(@ModelAttribute  @Valid Produit p , BindingResult bindingResult, Model m) {
    if (bindingResult.hasErrors()){
      m.addAttribute("categories" , serviceCategorie.getAllCategories());
      return "form";
    }
    serviceProduit.saveProduct(p);
    return "redirect:/index";
  }

  @GetMapping("/product/{id}")
  public String getProduct(@PathVariable Long id, Model model) {
    var product = serviceProduit.getProduct(id);
    List<Categorie> categoriesList = serviceCategorie.getAllCategories(); // Adjust this based on your service method
    model.addAttribute("product", product);
    model.addAttribute("categoriesList", categoriesList);
    return "update";
  }

  @PostMapping("/updateProduct/{id}")
  public String updateProduct(@PathVariable Long id, @ModelAttribute Produit p) {
    serviceProduit.updateProduct(id, p);
    return "redirect:/index";
  }
}

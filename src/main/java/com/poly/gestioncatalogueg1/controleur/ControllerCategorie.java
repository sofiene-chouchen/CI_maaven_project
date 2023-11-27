package com.poly.gestioncatalogueg1.controleur;

import com.poly.gestioncatalogueg1.entities.Categorie;
import com.poly.gestioncatalogueg1.service.ServiceCategorie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller()
public class ControllerCategorie {

  private ServiceCategorie serviceCategorie;

  ControllerCategorie(ServiceCategorie serviceCategorie) {
    this.serviceCategorie = serviceCategorie;
  }

  @GetMapping("/categories")
  public String getAllCategories(Model m) {

    List<Categorie> l = serviceCategorie.getAllCategories();
    m.addAttribute("categories", l);
    return "categories";

  }

  @PostMapping("/addCategorie")
  public String addCategorie(@ModelAttribute Categorie c) {
    serviceCategorie.saveCategorie(c);
    return "redirect:/categories";
  }

}

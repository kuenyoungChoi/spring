package cky.controller;

import cky.domain.Prod;
import cky.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdController {

    private ProdService prodService;


    @Autowired
    public ProdController(ProdService prodService) {
        this.prodService = prodService;
    }

    @GetMapping(value = "/prods/new")
    public String createForm() {
        return "prods/createProdForm";
    }

    @PostMapping(value = "/prods/new")
    public String create(ProdForm form) {
        Prod prod = new Prod();
        prod.setName(form.getName());

        prodService.createProd(prod);

        return "redirect:/";
    }

    @GetMapping(value = "/prods")
    public String list(Model model) {
        List<Prod> prods = prodService.findProds();
        model.addAttribute("prods", prods);
        return "prods/prodList";
    }
}

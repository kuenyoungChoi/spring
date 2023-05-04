package cky.controller;

import cky.service.ProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProdController {

    private ProdService prodService;


    @Autowired
    public ProdController(ProdService prodService) {
        this.prodService = prodService;
    }
}

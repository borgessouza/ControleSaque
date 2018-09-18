package br.com.ks.saques.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping({ "/entrar", "/" } )
    public String logar() {
        return "principal";
    }

    @GetMapping("/sair")
    public String sair() {
        return "sair";
    }

    @GetMapping("cadastros")
    public String cadastro(){
        return "cadastros";
    }

    @GetMapping("saque")
    public String saque() {
        return "saque";
    }

}

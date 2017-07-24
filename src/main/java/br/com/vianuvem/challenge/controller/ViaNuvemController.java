package br.com.vianuvem.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by eltonmoraes on 7/23/17.
 */
@Controller
public class ViaNuvemController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/lists")
    public String lists(){
        return "lists";
    }

}

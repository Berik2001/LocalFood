package localfood.controller;

import localfood.service.burger.BurgerService;
import localfood.service.kfc.KfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KfcController {
    @Autowired
    private KfcService kfcService;
    @GetMapping("/kfc")
    public String viewKfcPage( Model model){
        model.addAttribute("kfc",kfcService.getAllKfc());

        return "/foods/kfc";
    }
}

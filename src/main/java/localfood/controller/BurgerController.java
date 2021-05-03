package localfood.controller;

import localfood.service.burger.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BurgerController {
    @Autowired
    private BurgerService burgerService;
    @GetMapping("/burger")
    public String viewBurgerPage( Model model){
        model.addAttribute("burgers",burgerService.getAllBurgers());

return "/foods/burger";
    }
}

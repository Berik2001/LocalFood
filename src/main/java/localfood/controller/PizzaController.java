package localfood.controller;

import localfood.service.burger.BurgerService;
import localfood.service.pizza.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;
    @GetMapping("/pizza")
    public String viewPizzaPage( Model model){
        model.addAttribute("pizzas",pizzaService.getAllPizza());

        return "/foods/pizza";
    }
}

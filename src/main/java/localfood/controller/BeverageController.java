package localfood.controller;

import localfood.service.beverage.BeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BeverageController {
    @Autowired
    private BeverageService beverageService;
    @GetMapping("/beverage")
    public String viewBeveragePage( Model model){
        model.addAttribute("beverages",beverageService.getAllBeverage());
        return "/foods/beverage";
    }
}

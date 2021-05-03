package localfood.controller;

import localfood.model.Burger;
import localfood.model.Customer;
import localfood.service.customer.CustomerService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class CustomerController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @Autowired
    private CustomerService customerService;

public Customer customer;

    @GetMapping("/")
    public String viewHomePage(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "/index";
    }

    @GetMapping("/register")
    public String viewRegistrationPage(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "/register";
    }
    @GetMapping("/login")
    public String viewLoginPage() {
        return "/login";
    }
    @GetMapping("/index")
    public String viewHomPage(@ModelAttribute Customer customer, Model model, String message, HttpSession session) {

        model.addAttribute("customer", customer);

        return "/index";
    }





    @PostMapping("/saveEmployee")
    public String addItems(@Valid  Customer customer, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            return "/register";
        }
        else{
            //save employee to database
            customerService.saveEmployee(customer);
            return "redirect:/login";

        }


    }


    }




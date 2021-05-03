package localfood.service.pizza;


import localfood.model.Burger;
import localfood.model.Pizza;
import localfood.repository.pizza.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    private PizzaRepository pizzaRepository;

    @Autowired
    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository= pizzaRepository;
    }


    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }
}

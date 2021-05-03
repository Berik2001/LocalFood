package localfood.service.burger;


import localfood.model.Burger;
import localfood.repository.burger.BurgerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BurgerServiceImpl implements BurgerService {
    private BurgerRepository burgerRepository;

    @Autowired
    public BurgerServiceImpl(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    @Override
    public List<Burger> getAllBurgers() {
        return burgerRepository.findAll();
    }
}

package localfood.service.beverage;


import localfood.model.Beverage;

import localfood.repository.beverage.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeverageServiceImpl implements BeverageService {
    private BeverageRepository beverageRepository;

    @Autowired
    public BeverageServiceImpl( BeverageRepository beverageRepository) {
        this.beverageRepository = beverageRepository;
    }


    @Override
    public List<Beverage> getAllBeverage() {
        return beverageRepository.findAll();
    }
}

package localfood.service.kfc;


import localfood.model.Burger;
import localfood.model.KFC;
import localfood.repository.kfc.KfcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KfcServiceImpl implements KfcService {
    private KfcRepository kfcRepository;

    @Autowired
    public KfcServiceImpl( KfcRepository kfcRepository) {
        this.kfcRepository = kfcRepository;
    }


    @Override
    public List<KFC> getAllKfc() {
        return kfcRepository.findAll();
    }
}

package localfood.repository.beverage;

import localfood.model.Beverage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BeverageRepository extends JpaRepository<Beverage,Long> {

}

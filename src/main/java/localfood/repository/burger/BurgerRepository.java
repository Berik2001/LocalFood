package localfood.repository.burger;

import localfood.model.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository  extends JpaRepository<Burger,Long> {

}

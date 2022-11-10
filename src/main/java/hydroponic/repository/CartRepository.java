package hydroponic.repository;

import hydroponic.model.CustomerCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CustomerCart, Integer> {
//    CustomerCart findByProduceIdAndCustomerId(Integer produce_id, Integer customer_id);
}

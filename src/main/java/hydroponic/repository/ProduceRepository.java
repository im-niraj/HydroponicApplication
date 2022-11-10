package hydroponic.repository;

import hydroponic.model.FreshProduce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduceRepository extends JpaRepository<FreshProduce, Integer> {
//    public List<FreshProduce> findByClientId(Integer userId);
}

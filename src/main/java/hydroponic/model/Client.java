package hydroponic.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Client extends User{

    @OneToMany
    private List<FreshProduce> produceList = new ArrayList<>();

}

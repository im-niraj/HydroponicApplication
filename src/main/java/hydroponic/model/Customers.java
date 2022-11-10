package hydroponic.model;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Customers extends User{
    @OneToMany
    List<CustomerCart> CartItems = new ArrayList<>();
}

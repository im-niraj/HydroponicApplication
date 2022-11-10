package hydroponic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CustomerCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartID;

    @ManyToOne
    @JoinColumn(name = "produce_id")
    private FreshProduce produce;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customers customers;

    private int quantity;
}

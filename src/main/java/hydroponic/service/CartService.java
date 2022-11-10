package hydroponic.service;

import hydroponic.model.CustomerCart;

import java.util.List;

public interface CartService {
    public String addProduceToCart(int produceId, int customerId);
    public List<CustomerCart> cartProduces(int customerId);
    public String removeProduceFromCartById(int produceId,  int customerId);
    public String deleteProduceFromCartById(int produceId,  int customerId);
}

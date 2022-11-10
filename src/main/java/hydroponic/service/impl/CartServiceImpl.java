package hydroponic.service.impl;

import hydroponic.model.CustomerCart;
import hydroponic.model.Customers;
import hydroponic.model.FreshProduce;
import hydroponic.model.User;
import hydroponic.repository.CartRepository;
import hydroponic.repository.ProduceRepository;
import hydroponic.repository.UserRepository;
import hydroponic.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProduceRepository produceRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addProduceToCart(int produceId, int customerId) {
        Customers customers = (Customers)userRepository.findById(customerId).get();
        if(customers.getCartItems().size() > 0){
            boolean isPresent = false;
            for(CustomerCart c : customers.getCartItems()){
                if(c.getProduce().getProduceId() == produceId){
                    c.setQuantity(c.getQuantity()+1);
                    cartRepository.save(c);
                    userRepository.save(customers);
                    isPresent = true;
                    break;
                }
            }
            if(!isPresent){
                FreshProduce produce = produceRepository.findById(produceId).get();
                CustomerCart customerCart = new CustomerCart();
                customerCart.setProduce(produce);
                customerCart.setQuantity(1);
                customerCart.setCustomers(customers);
                customers.getCartItems().add(cartRepository.save(customerCart));
                userRepository.save(customers);
            }
            return "Product added to cart";
        }
        FreshProduce produce = produceRepository.findById(produceId).get();
        CustomerCart customerCart = new CustomerCart();
        customerCart.setProduce(produce);
        customerCart.setQuantity(1);
        customerCart.setCustomers(customers);
        customers.getCartItems().add(cartRepository.save(customerCart));
        userRepository.save(customers);
        return "Product added to cart";
    }

    @Override
    public List<CustomerCart> cartProduces(int customerId) {
        Customers customers =(Customers)userRepository.findById(customerId).get();
        if(customers.getCartItems().size() > 0){
            return customers.getCartItems();
        }
        return new ArrayList<>();
    }

    @Override
    public String removeProduceFromCartById(int produceId, int customerId) {
//        CustomerCart customerCart = cartRepository.findByProduceIdAndCustomerId(produceId,customerId);
//        if(customerCart != null){
//            if(customerCart.getQuantity() > 1){
//                customerCart.setQuantity(customerCart.getQuantity()-1);
//                cartRepository.save(customerCart);
//                return "Product removed successfully";
//            }
//            else {
//                deleteProduceFromCartById(produceId, customerId);
//            }
//        }
        return "Record not found";
    }

    @Override
    public String deleteProduceFromCartById(int produceId, int customerId) {
//        Customers customers =(Customers)userRepository.findById(customerId).get();
//        if(customers.getCartItems().size() > 0){
//            List<CustomerCart> list = customers.getCartItems();
//            CustomerCart customerCart = cartRepository.findByProduceIdAndCustomerId(produceId,customerId);
//            list.remove(customerCart);
//            userRepository.save(customers);
//            cartRepository.deleteById(customerCart.getCartID());
//        }
        return "Product deleted from cart";
    }
}

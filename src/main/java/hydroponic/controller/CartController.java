package hydroponic.controller;

import hydroponic.model.CustomerCart;
import hydroponic.repository.CartRepository;
import hydroponic.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/customer")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;


    @PostMapping("/addProductToCart/{produceId}/{clientId}")
    public ResponseEntity<String> addProductToCart(@PathVariable int  produceId, @PathVariable int clientId){
        return new ResponseEntity<>(cartService.addProduceToCart(produceId, clientId), HttpStatus.CREATED);
    }

    @GetMapping("/cart_produces/{clientId}")
    public ResponseEntity<List<CustomerCart>> cartProduces(@PathVariable int clientId){
        return new ResponseEntity<>(cartService.cartProduces(clientId), HttpStatus.OK);
    }

    @DeleteMapping("/removeProductFromCartById/{produceId}/{clientId}")
    public ResponseEntity<String> removeProduceFromCartById(@PathVariable int produceId, @PathVariable int clientId){
        return new ResponseEntity<>(cartService.removeProduceFromCartById(produceId, clientId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteProduceFromCartById/{produceId}/{clientId}")
    public ResponseEntity<String> deleteProductFromCartById(@PathVariable int produceId,@PathVariable int clientId){
        return new ResponseEntity<>(cartService.deleteProduceFromCartById(produceId, clientId), HttpStatus.ACCEPTED);
    }

    @PostMapping("/demoRemove/{produceId}/{clientId}")
    public CustomerCart remove(@PathVariable int produceId,@PathVariable int clientId){
//        CustomerCart customerCart = cartRepository.findByProduceIdAndCustomerId(produceId,clientId);
//        System.out.println(customerCart);
        return null;
    }
}

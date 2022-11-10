package hydroponic.controller;

import hydroponic.model.FreshProduce;
import hydroponic.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ProduceService produceService;

    @GetMapping("/allProduce")
    public ResponseEntity<?> getAllProduce(){
        return ResponseEntity.ok(produceService.getAllProduce());
    }


    @PostMapping("/addProduce/{clientId}")
    public ResponseEntity<String> addNewProduct(@RequestBody FreshProduce produce, @PathVariable int clientId){
        return new ResponseEntity<String>(produceService.addNewProduce(produce, clientId), HttpStatus.CREATED);
    }


    @GetMapping("/getAllProduceByClient/{clientId}")
    public ResponseEntity<?> getAllProduceByClient( @PathVariable int clientId){
        return ResponseEntity.ok(produceService.getAllProduceByClient(clientId));
    }


    @DeleteMapping("/deleteProduce/{produceId}/{clientId}")
    public ResponseEntity<String> deleteProduce(@PathVariable int produceId, @PathVariable int clientId){
        return new ResponseEntity<>(produceService.deleteProduce(produceId,clientId), HttpStatus.ACCEPTED);
    }

    @GetMapping("/produce/{produceId}/{clientId}")
    public ResponseEntity<FreshProduce> getProductById(@PathVariable int produceId, @PathVariable int clientId){
        return new ResponseEntity<FreshProduce>(produceService.getProduceById(produceId ,clientId), HttpStatus.OK);
    }

}

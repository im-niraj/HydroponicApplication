package hydroponic.service;

import hydroponic.model.FreshProduce;

import java.util.List;

public interface ProduceService {
    String addNewProduce(FreshProduce produce, int clientId);
    List<FreshProduce> getAllProduce();
    List<FreshProduce> getAllProduceByClient( int clientId);
    String deleteProduce(int productId, int clientId);
    FreshProduce getProduceById(int produceId, int clientId);
    String updateProduce(int produceId, int clientId, FreshProduce produce);
    String updatePrice(int produceId, int clientId, double price);
}

package hydroponic.service.impl;

import hydroponic.model.Client;
import hydroponic.model.FreshProduce;
import hydroponic.repository.ProduceRepository;
import hydroponic.repository.UserRepository;
import hydroponic.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduceServiceImpl implements ProduceService {

    @Autowired
    private ProduceRepository produceRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String addNewProduce(FreshProduce produce, int clientId) {
        Client client = (Client)userRepository.findById(clientId).get();
        produce.setClient(client);
        produceRepository.save(produce);
        return "Product Added successfully";
    }

    @Override
    public List<FreshProduce> getAllProduce() {
        return produceRepository.findAll();
    }

    @Override
    public List<FreshProduce> getAllProduceByClient(int clientId) {
        return produceRepository.findAll();
    }

    @Override
    public String deleteProduce(int produceId, int clientId) {
        List<FreshProduce> list = produceRepository.findAll();
        boolean isAvailable = false;
        for(FreshProduce p : list){
            if(p.getProduceId() == produceId){
                isAvailable = true;
                break;
            }
        }
        if(isAvailable){
            produceRepository.deleteById(produceId);
            return "Produce Deleted Successfully...";
        }
        return "Produce id is invalid";
    }

    @Override
    public FreshProduce getProduceById(int produceId, int clientId) {
        Optional<FreshProduce> optProduce =  produceRepository.findById(produceId);
        if(optProduce.isPresent()){
            return optProduce.get();
        }
        return null;
    }

    @Override
    public String updateProduce(int produceId, int clientId, FreshProduce produce) {

        return null;
    }

    @Override
    public String updatePrice(int produceId, int clientId, double price) {
        return null;
    }
}

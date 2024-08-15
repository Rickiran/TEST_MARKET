package com.Test_Market.Domain.service;

import com.Test_Market.Domain.purchase;
import com.Test_Market.Persistance.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class purchaseService {
    @Autowired
    private PurchaseRepository pRepository;

    public List<purchase> getAll(){
        return pRepository.getAll();
    }

    public Optional<purchase> getByClient(int ClientId){
        return  pRepository.getByClient(ClientId);
    }

    public purchase save(purchase prchse){
        return pRepository.save(prchse);
    }

}

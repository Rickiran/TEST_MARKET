package com.Test_Market.Persistance;

import com.Test_Market.Domain.purchase;
import com.Test_Market.Domain.repository.purchaseRepository;
import com.Test_Market.Persistance.Crud.purchaseCrudRepository;
import com.Test_Market.Persistance.Entity.purchasing;
import com.Test_Market.Persistance.Mapper.purchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements purchaseRepository {
    @Autowired
    private purchaseCrudRepository pCrudRep;
    //@Autowired
    private purchaseMapper purMapper;

    @Override
    public List<purchase> getAll() {
        return purMapper.toPurchases((List<purchasing>) pCrudRep.findAll());
    }

    @Override
    public Optional<purchase> getByClient(int ClientId) {

        return pCrudRep.findByIdCustomer(ClientId)
                .map(Purchase -> purMapper.toPurchase(Purchase));
    }

    @Override
    public purchase save(purchase prchse) {
        purchasing pchs = purMapper.toPurchasing(prchse);
        pchs.getProdPurch().forEach(product -> product.setPurch(pchs));

        return purMapper.toPurchase(pCrudRep.save(pchs));
    }
}
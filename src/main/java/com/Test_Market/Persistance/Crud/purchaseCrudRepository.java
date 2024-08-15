package com.Test_Market.Persistance.Crud;

import com.Test_Market.Persistance.Entity.purchasing;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface purchaseCrudRepository extends CrudRepository <purchasing,Integer>{

        Optional<purchasing> findByIdCustomer(int idCustomer);

}

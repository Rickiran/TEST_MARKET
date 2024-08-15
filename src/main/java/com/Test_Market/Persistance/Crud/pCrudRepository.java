package com.Test_Market.Persistance.Crud;


import com.Test_Market.Persistance.Entity.ProductPers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface pCrudRepository extends CrudRepository<ProductPers,Integer> {

        //@Query(value = "Select * from customer where Id=?", nativeQuery = true)

        Optional<ProductPers> findById(int idProduct);
        List<ProductPers> findByIdCategoryOrderByNameAsc(int idCategory);
        Optional<List<ProductPers>> findByQuantityLessThan(int quantity);

}

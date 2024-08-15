package com.Test_Market.Domain.service;

import com.Test_Market.Domain.ProductDom;
import com.Test_Market.Persistance.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    public ProductCrudRepository PrdctRep;

    public List<ProductDom> getAll(){
      return  PrdctRep.getAll();
    }

    public Optional<List<ProductDom>> getByCategory(int categoryId){
        return PrdctRep.getByCategory(categoryId);
    }

    public Optional<List<ProductDom>> getScarseProducts(int quantity){
        return PrdctRep.getScarseProducts(quantity);
    }

    public Optional<ProductDom> getProduct(int productId){
        return PrdctRep.getProduct(productId);
    }

    public ProductDom save(ProductDom prod){
       return PrdctRep.save(prod);
    }

    public boolean delete(int productId){
     return getProduct(productId).map(product ->{
             PrdctRep.delete(productId);
             return true;
             }).orElse(false);
      /*if(getProduct(productId).isPresent()){
          PrdctCrudRep.delete(productId);
          return true;
      }
      else{
          return false;
      }*/

    }

    }

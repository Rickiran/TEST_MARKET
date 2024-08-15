package com.Test_Market.Persistance;

import com.Test_Market.Domain.ProductDom;
import com.Test_Market.Persistance.Crud.pCrudRepository;
import com.Test_Market.Persistance.Entity.ProductPers;
import com.Test_Market.Persistance.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.Test_Market.Domain.repository.productRepository;
import java.util.List;
import java.util.Optional;

@Repository

public class ProductCrudRepository implements productRepository{

    @Autowired
    public pCrudRepository productCrudRepository;

    @Autowired
    public ProductMapper mapper;

    @Override
    public List<ProductDom> getAll(){
       List<ProductPers> prodctEnt=(List<ProductPers>) productCrudRepository.findAll();
       return mapper.toProductsDom(prodctEnt);
    }

    @Override
    public Optional<List<ProductDom>> getByCategory(int categoryId) {
        List<ProductPers> prodctEnt= productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDom(prodctEnt));

    }

    @Override
    public Optional<List<ProductDom>> getScarseProducts(int quantity) {
        Optional<List<ProductPers>> prodctEnt  = productCrudRepository.findByQuantityLessThan(quantity);
        return prodctEnt.map(prodct->mapper.toProductsDom(prodct));
    }

    @Override
    public Optional<ProductDom> getProduct(int productId) {
       return  productCrudRepository.findById(productId).map(prod->mapper.toProductDom(prod));

    }

    @Override
    public ProductDom save (ProductDom prod){
        ProductPers pct=mapper.toProductPers(prod);
        return mapper.toProductDom(productCrudRepository.save(pct));
    }

    @Override
    public void delete(int productId){
      productCrudRepository.deleteById(productId);
    }

}

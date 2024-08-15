package com.Test_Market.Domain.repository;
import com.Test_Market.Domain.ProductDom;
import java.util.List;
import java.util.Optional;

public interface productRepository {

    List<ProductDom> getAll();
    Optional<List<ProductDom>> getByCategory(int categoryId);
    Optional<List<ProductDom>>  getScarseProducts(int quantity);
    Optional<ProductDom> getProduct(int productId);
    ProductDom save (ProductDom prdct);
    void delete (int productId);
}

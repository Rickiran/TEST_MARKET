package com.Test_Market.Persistance.Mapper;

import com.Test_Market.Persistance.Entity.ProductPers;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.Test_Market.Domain.ProductDom;
import java.util.List;

@Mapper(componentModel="spring" , uses ={CategoryMapper.class})
public interface ProductMapper {
   @Mappings({
           @Mapping(source = "idProduct", target = "productId"),
           @Mapping(source = "name", target = "name"),
           @Mapping(source = "idCategory", target = "categoryId"),
           @Mapping(source = "sellingPrice", target = "price"),
           @Mapping(source = "quantity", target = "stock"),
           @Mapping(source = "status", target = "active"),
           @Mapping(source = "category", target = "ctgry")
   })
   ProductDom toProductDom(ProductPers product);
   List<ProductDom> toProductsDom(List<ProductPers> products);

   @InheritInverseConfiguration
   @Mapping(target="barcode",ignore = true)
   ProductPers toProductPers(ProductDom product);

}

package com.Test_Market.Persistance.Mapper;

import com.Test_Market.Persistance.Entity.products_purchasingPK;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.Test_Market.Domain.purchaseItem;
import com.Test_Market.Persistance.Entity.products_purchasing;

@Mapper(componentModel = "spring")
public interface purchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.id_product", target = "productId"),  // Map the product ID correctly
            @Mapping(source = "quantity", target = "quantity"),
            @Mapping(source = "status", target = "active")
    })
    purchaseItem toPurchaseItem(products_purchasing prdPrchsng);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "purch", ignore = true),  // Ignore the purchasing object
            @Mapping(target = "id", ignore = true),  // Ignore the product object
            @Mapping(target = "id.id_purchasing", ignore = true)  // Ignore the purchasing ID part of the composite key
    })
    products_purchasing toProdPurch(purchaseItem pItem);

    // Mapping method for product ID
    default int map(products_purchasingPK value) {
        return value.getId_product();  // Assuming getId_product() returns the product ID
    }
}
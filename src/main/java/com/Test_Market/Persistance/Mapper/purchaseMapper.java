package com.Test_Market.Persistance.Mapper;

import com.Test_Market.Persistance.Entity.purchasing;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.Test_Market.Domain.purchase;
import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {purchaseItemMapper.class})
public interface purchaseMapper {
    @Mappings({
            @Mapping(source="id_purchasing",target = "purchaseId"),
            @Mapping(source="idCustomer",target = "clientId"),
            @Mapping(source="date",target = "date"),
            @Mapping(source="paymentMethod",target = "paymentMethod"),
            @Mapping(source="comments",target = "comments"),
            @Mapping(source="status",target = "active"),
            @Mapping(source = "prodPurch", target = "items")
    })

    purchase toPurchase(purchasing ps);
    List<purchase> toPurchases(List<purchasing> pss);

    @InheritInverseConfiguration
    @Mapping(target="idCustomer",ignore = true)
    purchasing toPurchasing(purchase pch);
    List<purchasing> toPurchasing(List<purchase> ps);
}

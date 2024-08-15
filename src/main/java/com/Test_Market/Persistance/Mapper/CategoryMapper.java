package com.Test_Market.Persistance.Mapper;
import com.Test_Market.Domain.category;
import com.Test_Market.Persistance.Entity.categories;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source="idCategory",target="categoryId"),
            @Mapping(source="description",target="category"),
            @Mapping(source="status",target="active")
    })
    category toCategory(categories ctgries);

    @InheritInverseConfiguration
    @Mapping(target="products",ignore = true)
    categories toCategories(category ctgry);
}

package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.dto.response.BrandResponseDTO;
import kz.g134.onlineShop.dto.response.CategoryResponseDTO;
import kz.g134.onlineShop.entity.Brand;
import kz.g134.onlineShop.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandResponseDTO toDTO(Brand brand);
}

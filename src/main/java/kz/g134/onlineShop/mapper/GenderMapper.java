package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.dto.response.BrandResponseDTO;
import kz.g134.onlineShop.dto.response.GenderResponseDTO;
import kz.g134.onlineShop.entity.Brand;
import kz.g134.onlineShop.entity.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    GenderResponseDTO toDTO(Gender gender);
}

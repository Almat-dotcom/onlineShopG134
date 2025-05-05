package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.dto.response.CategoryResponseDTO;
import kz.g134.onlineShop.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponseDTO toDTO(Category category);

    List<CategoryResponseDTO> toDTOList(List<Category> category);
}

package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {
                CategoryMapper.class,
                MapperHelper.class,
                BrandMapper.class,
                GenderMapper.class
        })
public interface ItemMapper {
    @Mapping(target = "category", source = "categories")
    ItemResponseDTO toResponseDTO(Item item);

    @Mapping(target = "category", source = "categories")
    List<ItemResponseDTO> toResponseDTOList(List<Item> item);

    @Mapping(target = "brand", source = "brandId", qualifiedByName = "mapToBrand")
    @Mapping(target = "gender", source = "genderId", qualifiedByName = "mapToGender")
    @Mapping(target = "categories", source = "categoriesId", qualifiedByName = "mapToCategories")
    @Mapping(target = "isAvailable", expression = "java(false)")
    Item toItem(ItemRequestDTO dto);

    ItemResponseFullDTO toFullDTO(Item item);
}

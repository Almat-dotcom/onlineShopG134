package kz.g134.onlineShop.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponseFullDTO {
    private Long id;
    private String name;
    private String description;
    private String size;
    private Integer price;
    private String color;
    private List<CategoryResponseDTO> categories;
    private BrandResponseDTO brand;
    private GenderResponseDTO gender;
}

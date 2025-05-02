package kz.g134.onlineShop.dto.response;

import kz.g134.onlineShop.entity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponseDTO {
    private String name;
    private Integer price;

}

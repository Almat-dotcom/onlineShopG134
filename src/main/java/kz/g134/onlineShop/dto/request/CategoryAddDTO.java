package kz.g134.onlineShop.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryAddDTO {
    private Long itemId;
    private List<Long> categoriesId;
}

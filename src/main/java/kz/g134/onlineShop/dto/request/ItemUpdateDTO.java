package kz.g134.onlineShop.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemUpdateDTO {
    private Long id;
    @NotNull(message = "Name cannot be null")
    private String name;
    private String description;
    @NotNull
    private String color;
    @NotNull
    private Integer size;
    @NotNull
    private Integer price;
    private Boolean isAvailable;
    @NotNull
    private Long brandId;
    private Long genderId;
    @NotNull
    private List<Long> categoriesId;
}

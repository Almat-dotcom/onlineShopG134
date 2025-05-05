package kz.g134.onlineShop.mapper;

import kz.g134.onlineShop.entity.Brand;
import kz.g134.onlineShop.entity.Category;
import kz.g134.onlineShop.entity.Gender;
import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.exception.BrandNotFoundException;
import kz.g134.onlineShop.repository.BrandRepository;
import kz.g134.onlineShop.repository.CategoryRepository;
import kz.g134.onlineShop.repository.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MapperHelper {
    private final BrandRepository brandRepository;
    private final GenderRepository genderRepository;
    private final CategoryRepository categoryRepository;

    @Named("mapToBrand")
    public Brand findByIdBrand(Long id) {
        return brandRepository.findById(id).orElseThrow(() -> new BrandNotFoundException("Brand not found"));
    }

    @Named("mapToGender")
    public Gender findByIdGender(Long id) {
        if(id == null) return null;
        return genderRepository.findById(id).orElse(null);
    }

    @Named("mapToCategories")
    public List<Category> findByIdCategories(List<Long> ids) {
        return categoryRepository.findAllByIdIn(ids);
    }
}

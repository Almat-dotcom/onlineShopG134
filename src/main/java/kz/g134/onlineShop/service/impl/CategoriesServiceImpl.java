package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.dto.request.CategoryAddDTO;
import kz.g134.onlineShop.entity.Category;
import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.exception.CategoryNotFoundException;
import kz.g134.onlineShop.repository.CategoryRepository;
import kz.g134.onlineShop.repository.ItemRepository;
import kz.g134.onlineShop.service.CategoriesService;
import kz.g134.onlineShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final CategoryRepository categoryRepository;
    private final ItemServiceImpl itemService;
    private final ItemRepository itemRepository;

    @Override
    public Void addCategory(CategoryAddDTO dto) {
        Item item = itemService.getById(dto.getItemId());
        for (Long id : dto.getCategoriesId()) {
            Category category = categoryRepository.findById(id).orElseThrow(()
                    -> new CategoryNotFoundException("Category not found by id: " + id));
            item.getCategories().add(category);
        }
        itemRepository.save(item);
        return null;
    }
}

package kz.g134.onlineShop.service;

import kz.g134.onlineShop.dto.request.CategoryAddDTO;
import kz.g134.onlineShop.entity.Category;

import java.util.List;

public interface CategoriesService {
    Void addCategory(CategoryAddDTO dto);
    List<Category> getAll();
}

package kz.g134.onlineShop.controller;

import kz.g134.onlineShop.dto.request.CategoryAddDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.entity.Category;
import kz.g134.onlineShop.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;


    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoriesService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> addCategory(@RequestBody CategoryAddDTO dto) {
        return new ResponseEntity<>(categoriesService.addCategory(dto),HttpStatus.OK);
    }

}

package kz.g134.onlineShop.controller;

import kz.g134.onlineShop.dto.request.CategoryAddDTO;
import kz.g134.onlineShop.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoriesController {
    private final CategoriesService categoriesService;

    @PutMapping
    public ResponseEntity<Void> addCategory(@RequestBody CategoryAddDTO dto) {
        return new ResponseEntity<>(categoriesService.addCategory(dto),HttpStatus.OK);
    }

}

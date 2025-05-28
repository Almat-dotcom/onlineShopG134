package kz.g134.onlineShop.controller;

import kz.g134.onlineShop.entity.Brand;
import kz.g134.onlineShop.entity.Category;
import kz.g134.onlineShop.service.BrandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/brands")
@RequiredArgsConstructor
public class BrandsController {
    private final BrandsService brandsService;

    @GetMapping
    public ResponseEntity<List<Brand>> getBrands() {
        return new ResponseEntity<>(brandsService.getAll(), HttpStatus.OK);
    }
}

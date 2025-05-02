package kz.g134.onlineShop.controller;

import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/items")
public class ItemController {

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> getItems() {}
}

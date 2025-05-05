package kz.g134.onlineShop.controller;

import jakarta.validation.Valid;
import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponseDTO>> getItems() {
        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ItemRequestDTO dto) {
        return new ResponseEntity<>(itemService.createItem(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemResponseFullDTO> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }
}

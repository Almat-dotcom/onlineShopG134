package kz.g134.onlineShop.controller;

import jakarta.validation.Valid;
import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.request.ItemUpdateDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<Page<ItemResponseDTO>> getItems(
            @RequestParam(name = "name", required = false) String name,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return new ResponseEntity<>(itemService.getAllItems(name, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ItemRequestDTO dto) {
        return new ResponseEntity<>(itemService.createItem(dto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ItemResponseFullDTO> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.getItemById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid ItemUpdateDTO dto) {
        return new ResponseEntity<>(itemService.updateItem(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return new ResponseEntity<>(itemService.deleteItem(id), HttpStatus.OK);
    }
}

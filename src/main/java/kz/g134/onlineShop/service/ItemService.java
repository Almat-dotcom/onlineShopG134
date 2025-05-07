package kz.g134.onlineShop.service;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.request.ItemUpdateDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Page<ItemResponseDTO> getAllItems(String name, Pageable pageable);

    Void createItem(ItemRequestDTO dto);

    ItemResponseFullDTO getItemById(Long id);

    Void updateItem(ItemUpdateDTO dto);

    Void deleteItem(Long id);
}

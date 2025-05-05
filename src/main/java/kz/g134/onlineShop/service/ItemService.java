package kz.g134.onlineShop.service;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;

import java.util.List;

public interface ItemService {
    List<ItemResponseDTO> getAllItems();

    Void createItem(ItemRequestDTO dto);

    ItemResponseFullDTO getItemById(Long id);
}

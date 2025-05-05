package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.exception.ItemNotFoundException;
import kz.g134.onlineShop.mapper.ItemMapper;
import kz.g134.onlineShop.repository.ItemRepository;
import kz.g134.onlineShop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemResponseDTO> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.toResponseDTOList(items);
    }

    @Override
    public Void createItem(ItemRequestDTO dto) {
        itemRepository.save(itemMapper.toItem(dto));
        return null;
    }

    @Override
    public ItemResponseFullDTO getItemById(Long id) {
        return itemMapper.toFullDTO(itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found")));
    }
}

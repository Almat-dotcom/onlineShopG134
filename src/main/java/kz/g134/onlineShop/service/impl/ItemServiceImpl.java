package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.request.ItemUpdateDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.exception.ItemNotFoundException;
import kz.g134.onlineShop.mapper.ItemMapper;
import kz.g134.onlineShop.repository.ItemRepository;
import kz.g134.onlineShop.service.ItemService;
import kz.g134.onlineShop.util.ItemSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Override
    public Page<ItemResponseDTO> getAllItems(String name, Pageable pageable) {
        Page<Item> items = itemRepository.findAll(ItemSpecification.getItemSpecification(name), pageable);
        return itemMapper.map(items);
    }

    @Override
    public Void createItem(ItemRequestDTO dto) {
        try {
            itemRepository.save(itemMapper.toItem(dto));
            log.info("Item created");
        } catch (Exception e) {
            log.error("Item create error reason: " + e.getMessage());
        }
        return null;
    }

    @Override
    public ItemResponseFullDTO getItemById(Long id) {
        return itemMapper.toFullDTO(getById(id));
    }

    public Item getById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }

    @Override
    public Void updateItem(ItemUpdateDTO dto) {
        itemRepository.save(itemMapper.toItem(dto));
        log.info("Item updated with id: " + dto.getId());
        return null;
    }

    @Override
    public Void deleteItem(Long id) {
        itemRepository.deleteById(id);
        log.info("Item deleted with id: " + id);
        return null;
    }
}

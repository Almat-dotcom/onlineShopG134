package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.dto.request.ItemRequestDTO;
import kz.g134.onlineShop.dto.request.ItemUpdateDTO;
import kz.g134.onlineShop.dto.response.ItemResponseDTO;
import kz.g134.onlineShop.dto.response.ItemResponseFullDTO;
import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.exception.ItemNotFoundException;
import kz.g134.onlineShop.mapper.ItemMapper;
import kz.g134.onlineShop.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
    @Mock
    private ItemRepository itemRepository;
    @Mock
    private ItemMapper itemMapper;

    @InjectMocks
    private ItemServiceImpl itemService;

    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item();
        item.setId(1L);
        item.setName("Test Item");
    }

    @Test
    void getAllItems_Success() {
        // Given
        Pageable pageable = PageRequest.of(0, 10);

        List<Item> items = Collections.singletonList(item);
        Page<Item> itemPage = new PageImpl<>(items, pageable, items.size());

        ItemResponseDTO itemResponseDTO = new ItemResponseDTO();
        itemResponseDTO.setName("Test Item");
        List<ItemResponseDTO> dtos = Collections.singletonList(itemResponseDTO);
        Page<ItemResponseDTO> dtoPage = new PageImpl<>(dtos, pageable, dtos.size());

        // Prepare
        when(itemRepository.findAll(any(Specification.class), eq(pageable))).thenReturn(itemPage);
        when(itemMapper.map(itemPage)).thenReturn(dtoPage);

        // Act
        Page<ItemResponseDTO> result = itemService.getAllItems("Test Item", pageable);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
        assertEquals("Test Item", result.getContent().get(0).getName());
    }

    @Test
    void createItem_Success() {
        ItemRequestDTO itemRequestDTO = new ItemRequestDTO();
        itemRequestDTO.setName("Test Item");


        when(itemMapper.toItem(itemRequestDTO)).thenReturn(item);

        assertDoesNotThrow(() -> itemService.createItem(itemRequestDTO));
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    void getItemById_Success() {
        Long id = 1l;

        ItemResponseFullDTO itemResponseFullDTO = new ItemResponseFullDTO();
        itemResponseFullDTO.setId(id);

        when(itemRepository.findById(id)).thenReturn(Optional.of(item));
        when(itemMapper.toFullDTO(item)).thenReturn(itemResponseFullDTO);

        ItemResponseFullDTO result = itemService.getItemById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void getItemById_Fail() {
        Long id = 1l;

        ItemResponseFullDTO itemResponseFullDTO = new ItemResponseFullDTO();
        itemResponseFullDTO.setId(id);

        when(itemRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ItemNotFoundException.class, () -> itemService.getItemById(id));
    }

    @Test
    void updateItem_Success() {
        ItemUpdateDTO itemUpdateDTO = new ItemUpdateDTO();
        itemUpdateDTO.setName("Test Item");

        when(itemMapper.toItem(itemUpdateDTO)).thenReturn(item);

        assertDoesNotThrow(() -> itemService.updateItem(itemUpdateDTO));
        verify(itemRepository, times(1)).save(item);
    }

    @Test
    void deleteItem_Success() {
        Long id = 1L;

        doNothing().when(itemRepository).deleteById(id);

        assertDoesNotThrow(() -> itemService.deleteItem(id));
        verify(itemRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteItem_Fail() {
        Long id = 1L;

        doThrow(EmptyResultDataAccessException.class).when(itemRepository).deleteById(id);
        assertThrows(EmptyResultDataAccessException.class, () -> itemService.deleteItem(id));
    }
}

package kz.g134.onlineShop.service.impl;

import kz.g134.onlineShop.entity.Brand;
import kz.g134.onlineShop.repository.BrandRepository;
import kz.g134.onlineShop.service.BrandsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandsServiceImpl implements BrandsService {
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}

package kz.g134.onlineShop.repository;

import kz.g134.onlineShop.entity.Item;
import kz.g134.onlineShop.util.ItemSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findAll(Specification<Item> specification, Pageable pageable);
}

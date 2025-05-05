package kz.g134.onlineShop.repository;

import kz.g134.onlineShop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAllByIdIn(List<Long> ids);
}

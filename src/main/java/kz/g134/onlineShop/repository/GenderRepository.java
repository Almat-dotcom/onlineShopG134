package kz.g134.onlineShop.repository;

import kz.g134.onlineShop.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Long> {
}

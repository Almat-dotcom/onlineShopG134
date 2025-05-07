package kz.g134.onlineShop.util;

import jakarta.persistence.criteria.Predicate;
import kz.g134.onlineShop.entity.Item;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ItemSpecification {
    public Specification<Item> getItemSpecification(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

//            if (maxPrice != null) {
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
//            }
//
//            if (name != null && !name.isEmpty()) {
//                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
//            }
//
//            if (countryId != null) {
//                Join<Car, Country> countryJoin = root.join("country");
//                predicates.add(criteriaBuilder.equal(countryJoin.get("id"), countryId));
//            }
//
//            if (categoryId != null) {
//                Join<Car, Category> categoryJoin = root.join("categories");
//                predicates.add(criteriaBuilder.equal(categoryJoin.get("id"), categoryId));
//            }

            Predicate commonPredicate = criteriaBuilder.and(predicates.toArray(new Predicate[0]));

            return commonPredicate;
        };
    }
}

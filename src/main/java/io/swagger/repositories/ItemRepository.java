package io.swagger.repositories;

import io.swagger.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findDistinctByCategoriesIn(List<Long> categories);
    List<Item> findByStatus(Item.StatusEnum status);
    List<Item> findDistinctByStatusAndCategoriesIn(Item.StatusEnum status, List<Long> categories);
}

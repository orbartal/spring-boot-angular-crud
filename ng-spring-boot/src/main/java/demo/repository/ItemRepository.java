package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.ItemDbE;


public interface ItemRepository extends JpaRepository<ItemDbE, Long> {
}

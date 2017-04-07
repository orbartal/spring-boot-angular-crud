package demo.service;

import java.util.List;

import demo.model.ItemDbE;

public interface ItemsServiceI {

	List<ItemDbE> getAll() throws Exception;

	ItemDbE create(ItemDbE item) throws Exception;

	ItemDbE edit(ItemDbE updatedItem, Long id) throws Exception;

	void remove(Long id) throws Exception;
}

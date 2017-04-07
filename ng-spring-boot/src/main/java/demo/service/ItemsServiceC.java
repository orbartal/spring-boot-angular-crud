package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.ItemDbE;
import demo.repository.ItemRepository;

@Service("ItemsServiceI")
public class ItemsServiceC implements ItemsServiceI {

	 @Autowired
	 private ItemRepository m_itemRepository;
	  
	@Override
	public List<ItemDbE> getAll() throws Exception {
		return m_itemRepository.findAll();
	}

	@Override
	public ItemDbE create(ItemDbE item) throws Exception {
	    item.setId(null);
		return m_itemRepository.saveAndFlush(item);
	}

	@Override
	public ItemDbE edit(ItemDbE item, Long id) throws Exception {
		item.setId(id);
		return m_itemRepository.saveAndFlush(item);
	}

	@Override
	public void remove(Long id) throws Exception {
		m_itemRepository.delete(id);
	}

}

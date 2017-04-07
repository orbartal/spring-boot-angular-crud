package demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import demo.model.ItemDbE;
import demo.service.ItemsServiceI;

@RestController
@RequestMapping("/items")
public class ItemController {
	
  @Autowired
  private ItemsServiceI m_itemsService;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<ItemDbE> findItems() throws Exception {
	  List<ItemDbE> result = m_itemsService.getAll();
	  return result;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public ItemDbE addItem(@RequestBody ItemDbE item) throws Exception {
	    ItemDbE result = m_itemsService.create(item);
	    return result;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ItemDbE updateItem(@RequestBody ItemDbE updatedItem, @PathVariable Long id) throws Exception {
	    ItemDbE result = m_itemsService.edit(updatedItem, id);
	    return result;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable Long id) throws Exception {
	  m_itemsService.remove(id);
  }
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.example.demo.persistence.domain.FullList;
import com.example.demo.persistence.domain.Item;
import com.example.demo.persistence.repo.ItemRepo;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class ItemServiceUnitTest {

	@Autowired
	private ItemService service;
	@MockBean
	private ItemRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	
	 private Item TEST_ITEM = new Item("Title", "message", false);
	 private List<Item> TEST_ITEMS = List.of(TEST_ITEM);
   private final Item TEST_SAVED_ITEM = new Item(1L,"Title", "message", false);
   private final Item TEST_SAVED_ITEM_2 = new Item(1L,"Title", "message", false);
	@Test
	public void testCreate() {
		Mockito.when(this.repo.save(TEST_ITEM)).thenReturn(TEST_SAVED_ITEM);
		
		Assertions.assertThat(this.service.create(this.TEST_ITEM).getId()).isEqualTo(TEST_SAVED_ITEM.getId());
		 Assertions.assertThat(this.service.create(this.TEST_ITEM).getTitle()).isEqualTo(TEST_SAVED_ITEM.getTitle());
		 Assertions.assertThat(this.service.create(this.TEST_ITEM).getMessage()).isEqualTo(TEST_SAVED_ITEM.getMessage());
		 Assertions.assertThat(this.service.create(this.TEST_ITEM).isDone()).isEqualTo(TEST_SAVED_ITEM.isDone());
		 
		 Mockito.verify(this.repo, Mockito.times(4)).save(this.TEST_ITEM);
	}
	
	@Test
	public void testReadAll() {
		Mockito.when(this.repo.findAll()).thenReturn(TEST_ITEMS);

		 Assertions.assertThat(this.service.readAll().get(0).getId()).isEqualTo(TEST_ITEMS.get(0).getId());
		 Assertions.assertThat(this.service.readAll().get(0).getTitle()).isEqualTo(TEST_ITEMS.get(0).getTitle());
		 Assertions.assertThat(this.service.readAll().get(0).getMessage()).isEqualTo(TEST_ITEMS.get(0).getMessage());
		 Assertions.assertThat(this.service.readAll().get(0).isDone()).isEqualTo(TEST_ITEMS.get(0).isDone());
		  Mockito.verify(this.repo, Mockito.times(4)).findAll();
		    
	}
	@Test
	public void testDelete() {
		Mockito.when(this.repo.existsById(TEST_ITEM.getId())).thenReturn(true);
		
		Assertions.assertThat(this.service.delete(this.TEST_ITEM.getId())).isEqualTo(false);

		 Mockito.verify(this.repo, Mockito.times(1)).deleteById(this.TEST_ITEM.getId());
	}
	
	@Test
	public void testDeleteFail() {
		Mockito.when(this.repo.existsById(TEST_ITEM.getId())).thenReturn(false);
		
		Assertions.assertThat(this.service.delete(this.TEST_ITEM.getId())).isEqualTo(true);

		 Mockito.verify(this.repo, Mockito.times(1)).deleteById(this.TEST_ITEM.getId());
	}
	
	@Test
	public void testReadOne() {
		
		Mockito.when(this.repo.findById(1l)).thenReturn(Optional.of(TEST_SAVED_ITEM_2));

		 Assertions.assertThat(this.service.readOne(1l).getId()).isEqualTo(TEST_SAVED_ITEM_2.getId());
		 Assertions.assertThat(this.service.readOne(1l).getTitle()).isEqualTo(TEST_SAVED_ITEM_2.getTitle());
		 Assertions.assertThat(this.service.readOne(1l).getMessage()).isEqualTo(TEST_SAVED_ITEM_2.getMessage());
		 Assertions.assertThat(this.service.readOne(1l).isDone()).isEqualTo(TEST_SAVED_ITEM_2.isDone());
		  Mockito.verify(this.repo, Mockito.times(4)).findById(1l);
		    
	}
	
}

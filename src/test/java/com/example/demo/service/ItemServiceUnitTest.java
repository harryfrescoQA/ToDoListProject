package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

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
	
	
	 private final Item TEST_ITEM = new Item("Title", "message", false);
   private final Item TEST_SAVED_ITEM = new Item(1L,"Title", "message", false);
//	@Test
//	public void testCreate() {
//		Mockito.when(this.repo.save(TEST_ITEM)).thenReturn(TEST_SAVED_ITEM);
//		 Assertions.assertThat(this.service.create(this.TEST_ITEM)).isEqualTo(this.TEST_SAVED_ITEM);
//		  Mockito.verify(this.repo, Mockito.times(1)).save(this.TEST_ITEM);
//	}
	
}

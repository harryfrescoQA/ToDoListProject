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
import com.example.demo.persistence.repo.FullListRepo;
import com.example.demo.persistence.repo.ItemRepo;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class FullListServiceUnitTest {

	@Autowired
	private FullListService service;
	@MockBean
	private FullListRepo repo;
	@Autowired
	private ModelMapper mapper;
	
	
	 //private Item TEST_ITEM = new Item(1l, "Title", "message", false);
	 
	
		
	private FullList list = new FullList("Title");
	private FullList list_Saved = new FullList(1l, "Title");
   private List<FullList> TEST_LISTS = List.of(list);

	@Test
	public void testCreate() {
		Mockito.when(this.repo.save(list)).thenReturn(list_Saved);
		
		Assertions.assertThat(this.service.create(this.list).getId()).isEqualTo(list_Saved.getId());
		 Assertions.assertThat(this.service.create(this.list).getTitle()).isEqualTo(list_Saved.getTitle());

		 
		 Mockito.verify(this.repo, Mockito.times(2)).save(this.list);
	}
	
	@Test
	public void testReadAll() {
		Mockito.when(this.repo.findAll()).thenReturn(TEST_LISTS);

		 Assertions.assertThat(this.service.readAll().get(0).getId()).isEqualTo(TEST_LISTS.get(0).getId());
		 Assertions.assertThat(this.service.readAll().get(0).getTitle()).isEqualTo(TEST_LISTS.get(0).getTitle());

		  Mockito.verify(this.repo, Mockito.times(2)).findAll();
		    
	}
	@Test
	public void testDelete() {
		Mockito.when(this.repo.existsById(list.getId())).thenReturn(true);
		
		Assertions.assertThat(this.service.delete(this.list.getId())).isEqualTo(false);

		 Mockito.verify(this.repo, Mockito.times(1)).deleteById(this.list.getId());
	}
	
	@Test
	public void testDeleteFail() {
		Mockito.when(this.repo.existsById(list.getId())).thenReturn(false);
		
		Assertions.assertThat(this.service.delete(this.list.getId())).isEqualTo(true);

		 Mockito.verify(this.repo, Mockito.times(1)).deleteById(this.list.getId());
	}
	@Test
	public void testReadOne() {
		
		Mockito.when(this.repo.findById(1l)).thenReturn(Optional.of(list_Saved));

		 Assertions.assertThat(this.service.readOne(1l).getId()).isEqualTo(list_Saved.getId());
		 Assertions.assertThat(this.service.readOne(1l).getTitle()).isEqualTo(list_Saved.getTitle());
	  Mockito.verify(this.repo, Mockito.times(2)).findById(1l);
		    
	}
	
}

package com.example.demo.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;


import com.example.demo.dto.ItemDTO;
import com.example.demo.persistence.domain.Item;
import com.example.demo.service.ItemService;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class ItemControllerUnitTest {

	@Autowired
	private ItemController controller;
	
	@MockBean
	private ItemService service;
	
	@Autowired
	private ModelMapper mapper;
	
	private ItemDTO maptoDto(Item item) {
		return this.mapper.map(item, ItemDTO.class);
	}
	
	// During our test we want give it some data to use
	private final Item TEST_ITEM_1 = new Item(1L, "Harry", "Harry Fresco", false);
	private final Item TEST_ITEM_2 = new Item(2L, "HarryF", "Harry Fresh", false);
		
	private final List<Item> LISTOFITEMS = List.of(TEST_ITEM_1, TEST_ITEM_2);
	
	// Create
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_ITEM_1)).thenReturn(this.maptoDto(TEST_ITEM_1));
		assertThat(new ResponseEntity<ItemDTO>(this.maptoDto(TEST_ITEM_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_ITEM_1));
		verify(this.service, atLeastOnce()).create(TEST_ITEM_1);

	}
	
	// Read one
		@Test
		void readOneTest() throws Exception {
			when(this.service.readOne(TEST_ITEM_1.getId())).thenReturn(this.maptoDto(TEST_ITEM_1));
			assertThat(new ResponseEntity<ItemDTO>(this.maptoDto(TEST_ITEM_1), HttpStatus.OK))
					.isEqualTo(this.controller.readOne(TEST_ITEM_1.getId()));
			verify(this.service, atLeastOnce()).readOne(TEST_ITEM_1.getId());
		}

		// Read all
		@Test
		void readAllTest() throws Exception {
			List<ItemDTO> dtos = LISTOFITEMS.stream().map(this::maptoDto).collect(Collectors.toList());
			when(this.service.readAll()).thenReturn(dtos);
			assertThat(this.controller.read()).isEqualTo(new ResponseEntity<>(dtos, HttpStatus.OK));
			verify(this.service, atLeastOnce()).readAll();

		}

		// Update
		@Test
		void UpdateTest() throws Exception {
			when(this.service.update(this.maptoDto(TEST_ITEM_1), TEST_ITEM_1.getId())).thenReturn(this.maptoDto(TEST_ITEM_1));
			assertThat(new ResponseEntity<ItemDTO>(this.maptoDto(TEST_ITEM_1), HttpStatus.ACCEPTED))
					.isEqualTo(this.controller.update(TEST_ITEM_1.getId(), this.maptoDto(TEST_ITEM_1)));
			verify(this.service, atLeastOnce()).update(this.maptoDto(TEST_ITEM_1), TEST_ITEM_1.getId());
		}

		// Delete
		@Test
		void deleteTest() throws Exception {
			when(this.service.delete(TEST_ITEM_1.getId())).thenReturn(false);
			assertThat(this.controller.delete(TEST_ITEM_1.getId()))
					.isEqualTo(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
			verify(this.service, atLeastOnce()).delete(TEST_ITEM_1.getId());

		}
		

		@Test
		void deleteTest2() throws Exception {
			when(this.service.delete(TEST_ITEM_1.getId())).thenReturn(true);
			assertThat(this.controller.delete(TEST_ITEM_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
			verify(this.service, atLeastOnce()).delete(TEST_ITEM_1.getId());

		}
}

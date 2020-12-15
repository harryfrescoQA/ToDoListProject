package com.example.demo.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
public class ItemDTOUnitTest {

	@Autowired
	private ModelMapper mapper;
	
	private ItemDTO maptoDto(Item item) {
		return this.mapper.map(item, ItemDTO.class);
	}
	
	@Test
	public void itemStringDTOTest() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		String toString = "ItemDTO(id=null, title=Title, message=message, done=false)";
		 assertEquals(toString, maptoDto(TEST_ITEM).toString() );
	
	}
	
	@Test
	public void itemHashcodeDTOTest() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		
		assertEquals(1460452470, maptoDto(TEST_ITEM).hashCode() );
	
	}
	
	@Test
	public void itemEqualsDTOTest() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		 Item TEST_ITEM_2 = new Item("Title", "message", false);
		 assertTrue(maptoDto(TEST_ITEM).equals(maptoDto(TEST_ITEM_2)));
	
	}
	@Test
	public void itemEqualsDTOTestFail() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		 Item TEST_ITEM_2 = new Item("Title2", "message", false);
		 assertFalse(maptoDto(TEST_ITEM).equals(TEST_ITEM_2));
	
	}
	@Test
	public void itemEqualsDTOTestFail2() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		 Item TEST_ITEM_2 = new Item("Title", "message2", false);
		 assertFalse(maptoDto(TEST_ITEM).equals(TEST_ITEM_2));
	
	}
	
	@Test
	public void itemEqualsDTOTestFail3() {
		 Item TEST_ITEM = new Item("Title", "message", false);
		 Item TEST_ITEM_2 = new Item("Title", "message", true);
		 assertFalse(maptoDto(TEST_ITEM).equals(TEST_ITEM_2));
	
	}
}

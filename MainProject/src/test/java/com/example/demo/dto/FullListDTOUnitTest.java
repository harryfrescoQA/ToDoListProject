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
import com.example.demo.persistence.domain.FullList;
import com.example.demo.persistence.domain.Item;
import com.example.demo.service.ItemService;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class FullListDTOUnitTest {

	@Autowired
	private ModelMapper mapper;
	
	private FullListDTO maptoDto(FullList fullList) {
		return this.mapper.map(fullList, FullListDTO.class);
	}
	
	@Test
	public void listStringDTOTest() {
		 FullList list = new FullList(1l, "Title");
		// FullList list_Saved = new FullList(1l, "Title");
	   // List<FullList> TEST_LISTS = List.of(list);
		 //Item TEST_ITEM = new Item("Title", "message", false);
		 
		String toString = "FullListDTO(id=1, title=Title, items=null)";
		 assertEquals(toString, maptoDto(list).toString() );
	
	}
	
	@Test
	public void listHashcodeDTOTest() {
		FullList list = new FullList(1l, "Title");
		
		assertEquals(473547503, maptoDto(list).hashCode() );
	
	}
	
	@Test
	public void listEqualsDTOTest() {
		FullList list = new FullList(1l, "Title");
		FullList list2 = new FullList(1l, "Title");

		 assertTrue(maptoDto(list).equals(maptoDto(list2)));
	
	}
	@Test
	public void listEqualsDTOTestFail() {
		FullList list = new FullList(1l, "Title");
		FullList list2 = new FullList(2l, "Title");
		 assertFalse(maptoDto(list).equals(maptoDto(list2)));
	
	}
	@Test
	public void listEqualsDTOTestFail2() {
		FullList list = new FullList(1l, "Title");
		FullList list2 = new FullList(1l, "Title2");
		 assertFalse(maptoDto(list).equals(maptoDto(list2)));
	
	}
	
	@Test
	public void listEqualsDTOTestFail3() {
		FullList list = new FullList(1l, "Title");
		FullList list2 = new FullList(1l, null);
		 assertFalse(maptoDto(list).equals(maptoDto(list2)));
	}
	
	@Test
	public void listEqualsDTOTestFail4() {
		FullList list = new FullList(1l, "Title");
		FullList list2 = new FullList(null, "Title");
		 assertFalse(maptoDto(list).equals(maptoDto(list2)));
	}
}

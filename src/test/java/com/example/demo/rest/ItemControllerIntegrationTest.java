package com.example.demo.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.dto.ItemDTO;
import com.example.demo.persistence.domain.FullList;
import com.example.demo.persistence.domain.Item;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:item-schema.sql",
				"classpath:item-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "dev")
public class ItemControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper jsonifier;

	@Autowired
	private ModelMapper mapper;

	private ItemDTO mapToDTO(Item item) {
		return this.mapper.map(item, ItemDTO.class);
	}
	
//create table full_list (id bigint generated by default as identity, 
	//title varchar(255) not null, primary key (id))
	//private final FullList TEST_LIST_1 = new FullList(1L, "Harry");	
	private final Item TEST_ITEM_1 = new Item(1L, "Harry", "Harry Fresco", false);
	
	private final Item TEST_ITEM_2 = new Item(2L, "HarryF", "Harry Fresh", false);
	
	//private final List<Item> LISTOFITEMS = List.of(TEST_ITEM_1, TEST_ITEM_2);
	
	private final String URI = "/item";
	
//	@Test
//	void createTest() throws Exception {
//		ItemDTO testDTO = mapToDTO(new Item(3l, "test", "testy", false));
//		
//		String testDTOAsJSON = this.jsonifier.writeValueAsString(testDTO);
//
//		RequestBuilder request = post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON);
//
//		ResultMatcher checkStatus = status().isCreated();
//
//		ItemDTO testSavedDTO = mapToDTO(new Item(3l, "test", "testy", false));
//		//testSavedDTO.setId(5L);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
////		this.mvc.perform(post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON))
////				.andExpect(status().isCreated()).andExpect(content().json(testSavedDTOAsJSON));
//	}
//	@Test
//	void readTest() throws Exception {
//		//ItemDTO testDTO = mapToDTO(new Item(3l, "test", "testy", false));
//	
//		
//		//String testDTOAsJSON = this.jsonifier.writeValueAsString(LISTOFITEMS);
//
//		RequestBuilder request = get(URI + "/read").contentType(MediaType.APPLICATION_JSON);
//
//		ResultMatcher checkStatus = status().isOk();
//		
//		//FullList TEST_LIST_1 = new FullList(1L, "Harry");	
//		ItemDTO testSavedDTO = mapToDTO(new Item(1L, "Harry", "Harry Fresco", false));
//		ItemDTO testSavedDTO2 = mapToDTO(new Item(2L, "HarryF", "Harry Fresh", false));
//		List<Item> LISTOFITEMS = List.of(TEST_ITEM_1, TEST_ITEM_2);
//		
//		//testSavedDTO.setId(5L);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(LISTOFITEMS);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//	
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
////		this.mvc.perform(post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON))
////				.andExpect(status().isCreated()).andExpect(content().json(testSavedDTOAsJSON));
//	}
//	
//	@Test
//	void readOneTest() throws Exception {
//		//ItemDTO testDTO = mapToDTO(new Item(3l, "test", "testy", false));
//	
//		
//		//String testDTOAsJSON = this.jsonifier.writeValueAsString(LISTOFITEMS);
//
//		RequestBuilder request = get(URI + "/read/1").contentType(MediaType.APPLICATION_JSON);
//
//		ResultMatcher checkStatus = status().isOk();
//		
//		//FullList TEST_LIST_1 = new FullList(1L, "Harry");	
//		ItemDTO testSavedDTO = mapToDTO(new Item(1L, "Harry", "Harry Fresco", false));
//		
//		//testSavedDTO.setId(5L);
//		String testSavedDTOAsJSON = this.jsonifier.writeValueAsString(testSavedDTO);
//
//		ResultMatcher checkBody = content().json(testSavedDTOAsJSON);
//	
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
//
////		this.mvc.perform(post(URI + "/create").contentType(MediaType.APPLICATION_JSON).content(testDTOAsJSON))
////				.andExpect(status().isCreated()).andExpect(content().json(testSavedDTOAsJSON));
//	}

}

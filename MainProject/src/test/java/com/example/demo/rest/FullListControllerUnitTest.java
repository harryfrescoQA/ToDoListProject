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

import com.example.demo.dto.FullListDTO;
import com.example.demo.dto.ItemDTO;
import com.example.demo.persistence.domain.FullList;
import com.example.demo.persistence.domain.Item;
import com.example.demo.service.FullListService;
import com.example.demo.service.ItemService;

@SpringBootTest // spring boot test lets spring know this is a test file and treat as such
@ActiveProfiles("dev")
public class FullListControllerUnitTest {

	@Autowired
	private FullListController controller;
	
	@MockBean
	private FullListService service;
	
	@Autowired
	private ModelMapper mapper;
	
	private FullListDTO maptoDto(FullList fullList) {
		return this.mapper.map(fullList, FullListDTO.class);
	}
	

	
	private final FullList TEST_LIST_1 = new FullList(1L, "Harry");	
	private final FullList TEST_LIST_2 = new FullList(2L, "HarryF");	
	private final List<FullList> LISTOFFULLLISTS = List.of(TEST_LIST_1, TEST_LIST_2);
	
	
	// Create
	@Test
	void createTest() throws Exception {
		when(this.service.create(TEST_LIST_1)).thenReturn(this.maptoDto(TEST_LIST_1));
		assertThat(new ResponseEntity<FullListDTO>(this.maptoDto(TEST_LIST_1), HttpStatus.CREATED))
				.isEqualTo(this.controller.create(TEST_LIST_1));
		verify(this.service, atLeastOnce()).create(TEST_LIST_1);

	}
	
	// Read one
		@Test
		void readOneTest() throws Exception {
			when(this.service.readOne(TEST_LIST_1.getId())).thenReturn(this.maptoDto(TEST_LIST_1));
			assertThat(new ResponseEntity<FullListDTO>(this.maptoDto(TEST_LIST_1), HttpStatus.OK))
					.isEqualTo(this.controller.readOne(TEST_LIST_1.getId()));
			verify(this.service, atLeastOnce()).readOne(TEST_LIST_1.getId());
		}

		// Read all
		@Test
		void readAllTest() throws Exception {
			List<FullListDTO> dtos = LISTOFFULLLISTS.stream().map(this::maptoDto).collect(Collectors.toList());
			when(this.service.readAll()).thenReturn(dtos);
			assertThat(this.controller.read()).isEqualTo(new ResponseEntity<>(dtos, HttpStatus.OK));
			verify(this.service, atLeastOnce()).readAll();

		}

		// Update
		@Test
		void UpdateTest() throws Exception {
			when(this.service.update(this.maptoDto(TEST_LIST_1), TEST_LIST_1.getId())).thenReturn(this.maptoDto(TEST_LIST_1));
			assertThat(new ResponseEntity<FullListDTO>(this.maptoDto(TEST_LIST_1), HttpStatus.ACCEPTED))
					.isEqualTo(this.controller.update(TEST_LIST_1.getId(), this.maptoDto(TEST_LIST_1)));
			verify(this.service, atLeastOnce()).update(this.maptoDto(TEST_LIST_1), TEST_LIST_1.getId());
		}

		// Delete
		@Test
		void deleteTest() throws Exception {
			when(this.service.delete(TEST_LIST_1.getId())).thenReturn(false);
			assertThat(this.controller.delete(TEST_LIST_1.getId()))
					.isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
			verify(this.service, atLeastOnce()).delete(TEST_LIST_1.getId());

		}
		

		@Test
		void deleteTest2() throws Exception {
			when(this.service.delete(TEST_LIST_1.getId())).thenReturn(true);
			assertThat(this.controller.delete(TEST_LIST_1.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
			verify(this.service, atLeastOnce()).delete(TEST_LIST_1.getId());

		}
}

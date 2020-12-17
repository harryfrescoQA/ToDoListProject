package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.dto.ItemDTO;
import com.example.demo.persistence.domain.Item;
import com.example.demo.service.ItemService;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

		private ItemService service;
		
		@Autowired
		public ItemController(ItemService service) {
			super();
			this.service = service;
		}
		
		// Create
		@PostMapping("/create")
		public ResponseEntity<ItemDTO> create(@RequestBody Item item) {
			ItemDTO created = this.service.create(item);
			return new ResponseEntity<>(created, HttpStatus.CREATED);


		}

		// read all
		@GetMapping("/read")
		public ResponseEntity<List<ItemDTO>> read() {
			return ResponseEntity.ok(this.service.readAll());
			// ok - 200
		}

		// read one
		// Takes in ID
		@GetMapping("/read/{id}")
		public ResponseEntity<ItemDTO> readOne(@PathVariable Long id) {
			return ResponseEntity.ok(this.service.readOne(id));
		}

		// update
		// Takes in ID and DTO
		@PutMapping("/update/{id}")
		public ResponseEntity<ItemDTO> update(@PathVariable Long id, @RequestBody ItemDTO bookDTO) {
			return new ResponseEntity<>(this.service.update(bookDTO, id), HttpStatus.ACCEPTED);
		}

		// Delete one
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<ItemDTO> delete(@PathVariable Long id) {
			return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					// if successful, return nothing
					: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
}

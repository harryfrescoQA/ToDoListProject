package com.example.demo.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FullListDTO;
import com.example.demo.persistence.domain.FullList;
import com.example.demo.service.FullListService;

@RestController
@CrossOrigin
@RequestMapping("/list")
public class FullListController {

	private FullListService service;
	
	@Autowired
	public FullListController(FullListService service) {
		super();
		this.service = service;
	}
	
	// Create method
		@PostMapping("/create")
		public ResponseEntity<FullListDTO> create(@RequestBody FullList fullList) {
			FullListDTO created = this.service.create(fullList);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
			// http status code - 201 (created)

		}

		// read all method
		@GetMapping("/read")
		public ResponseEntity<List<FullListDTO>> read() {
			return ResponseEntity.ok(this.service.readAll());
			// ok - 200
		}

		// read one
		@GetMapping("/read/{id}")
		public ResponseEntity<FullListDTO> readOne(@PathVariable Long id) {
			return ResponseEntity.ok(this.service.readOne(id));
		}

		// update
		@PutMapping("/update/{id}")
		public ResponseEntity<FullListDTO> update(@PathVariable Long id, @RequestBody FullListDTO fullListDTO) {
			return new ResponseEntity<>(this.service.update(fullListDTO, id), HttpStatus.ACCEPTED);
		}

		// Delete one
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<FullListDTO> delete(@PathVariable Long id) {
			return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					// no_content - if deleted successfully then should return nothing
					: new ResponseEntity<>(HttpStatus.NOT_FOUND);
			// if the record isnt found!
		}
}

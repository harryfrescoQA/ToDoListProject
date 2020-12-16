package com.example.demo.service;
import java.util.List;


import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FullListDTO;
import com.example.demo.exceptions.FullListNotFoundException;
import com.example.demo.persistence.domain.FullList;
import com.example.demo.persistence.repo.FullListRepo;
import com.example.demo.util.SpringBeanUtil;

@Service
public class FullListService {
	private FullListRepo repo;

	private ModelMapper mapper;

	private FullListDTO mapToDTO(FullList fullList) {
		return this.mapper.map(fullList, FullListDTO.class);
	}

	@Autowired
	public FullListService(FullListRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	// Create
	public FullListDTO create(FullList fullList) {
		return this.mapToDTO(this.repo.save(fullList));
	}

	// read all method
	public List<FullListDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	// read one method
	public FullListDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(FullListNotFoundException::new));
	}

	// update
	public FullListDTO update(FullListDTO fullListDTO, Long id) {
		// check if record exists
		FullList toUpdate = this.repo.findById(id).orElseThrow(FullListNotFoundException::new);
		// set the record to update
		toUpdate.setTitle(fullListDTO.getTitle());
		// check update for any nulls
		SpringBeanUtil.mergeNotNull(fullListDTO, toUpdate);
		// retun the method from repo
		return this.mapToDTO(this.repo.save(toUpdate));

	}

	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);// true
		return !this.repo.existsById(id);// true
	}
}

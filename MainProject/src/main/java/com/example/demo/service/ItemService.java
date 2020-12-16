package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ItemDTO;
import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.persistence.domain.Item;
import com.example.demo.persistence.repo.ItemRepo;
import com.example.demo.util.SpringBeanUtil;

@Service
public class ItemService {

	private ItemRepo repo;
	private ModelMapper mapper;
	
	private ItemDTO mapToDTO(Item item) {
		return this.mapper.map(item, ItemDTO.class);
	}
	
	@Autowired
	public ItemService(ItemRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	// Create
		public ItemDTO create(Item item) {
			return this.mapToDTO(this.repo.save(item));
		}
		
	// read all method
	public List<ItemDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	// read one method
	public ItemDTO readOne(Long id) {
		return this.mapToDTO(this.repo.findById(id).orElseThrow(ItemNotFoundException::new));
	}
	// update
	public ItemDTO update(ItemDTO itemDTO, Long id) {
		// check if record exists
		Item toUpdate = this.repo.findById(id).orElseThrow(ItemNotFoundException::new);
		// set the record to update
		toUpdate.setTitle(itemDTO.getTitle());
		// check update for any nulls
		SpringBeanUtil.mergeNotNull(itemDTO, toUpdate);
		// return the method from repo
		return this.mapToDTO(this.repo.save(toUpdate));

	}
	// Delete
	public boolean delete(Long id) {
		this.repo.deleteById(id);// true
		return !this.repo.existsById(id);// true
	}
}

package com.example.demo.dto;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FullListDTO {
	private Long id;
	private String title;
	private List<ItemDTO> items = new ArrayList<>();
	
}

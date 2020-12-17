package com.example.demo.dto;




import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO {
	// DTO for the Item Object
	private Long id;
	private String title;
	private String message;
	private boolean done;

}

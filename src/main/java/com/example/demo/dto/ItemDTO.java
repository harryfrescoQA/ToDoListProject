package com.example.demo.dto;




import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO {
	private Long id;
	private String title;
	private String message;
	private boolean done;

}

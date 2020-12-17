package com.example.demo.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // classes that represent tables in our DB
@Data
@NoArgsConstructor
public class Item {
	
	//Id, name, author, isbn
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String title;
	
	@NotNull
	private String message;
	
	@NotNull
	private boolean done;
	
	// Many items have one list
	@ManyToOne
	private FullList fullList;
	

	public Item(Long id, @NotNull String title, @NotNull String message, @NotNull boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.message = message;
		this.done = done;
	}

	public Item(@NotNull String title, @NotNull String message, @NotNull boolean done) {
		super();
		this.title = title;
		this.message = message;
		this.done = done;
	}


	

	
	
}

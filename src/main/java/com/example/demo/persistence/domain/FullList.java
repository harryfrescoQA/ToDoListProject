package com.example.demo.persistence.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity // classes that represent tables in our DB
@Data
@NoArgsConstructor
public class FullList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotNull
	public String title;
	
	@OneToMany(mappedBy = "fullList", fetch = FetchType.EAGER)
	private List<Item> items;

	public FullList(Long id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public FullList(String title) {
		super();
		this.title = title;
	}
	

}

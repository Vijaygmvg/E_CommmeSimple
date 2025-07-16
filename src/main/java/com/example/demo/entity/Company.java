package com.example.demo.entity;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Company {
	
	public Company(String name) {
		this.name=name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	
	private String name;
	
	@OneToMany(mappedBy="company")
	@Lazy
	private List<Product> products;

}

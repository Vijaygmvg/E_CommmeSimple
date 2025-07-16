package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AppUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int age;
	
	private String imageUrl;
	
	
	private List<Long> cartList;
	
	private LocalDateTime cretedAt;
	
	private LocalDateTime updatedAt;
	
	

}

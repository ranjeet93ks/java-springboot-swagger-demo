package com.java.springboot.swagger.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book implements Serializable {

	private static final long serialVersionUID = -6241499658373358901L;
	
	@Id
	@GeneratedValue
	private int id;
	private String bookName;
	private double price;
}

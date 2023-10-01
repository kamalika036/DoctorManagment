package com.mycompany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Doctor_details")

public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotBlank(message = "Invalid name :Empty name")
	@jakarta.validation.constraints.NotNull(message = "Invalid name: name can not be null")
	@Size(min = 3, max = 30, message = "Invalid name must be of 3-30 characters")
	private String name;

	@NotBlank(message = "Invalid name :Empty name")
	@jakarta.validation.constraints.NotNull(message = "Invalid name: name can not be null")
	private String specalization;

	public Doctor(String name, String specalization) {
		super();
		this.name = name;
		this.specalization = specalization;
	}

}

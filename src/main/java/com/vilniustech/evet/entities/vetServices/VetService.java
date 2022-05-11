/**
 * @(#) VetService.java
 */

package com.vilniustech.evet.entities.vetServices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "vet_services")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VetService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private double price;

	@NotNull
	@Column(name = "vet_service_code")
	private String vetServiceCode;
}

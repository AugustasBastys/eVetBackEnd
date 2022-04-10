/**
 * @(#) VetService.java
 */

package com.vgtu.evet.entities.vetServices;

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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	@NotNull
	private Doctor doctor;
}

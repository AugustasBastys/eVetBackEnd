
package com.vilniustech.evet.entities.vetServices;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "veterinarians")
@Data
public class Veterinarian
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private SpecialtyType specialty;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vet_service_id", referencedColumnName = "id")
	@NotNull
	private VetService vetService;

}

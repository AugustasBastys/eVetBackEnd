
package com.vgtu.evet.entities.vetServices;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "doctors")
@Data
public class Doctor
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

}

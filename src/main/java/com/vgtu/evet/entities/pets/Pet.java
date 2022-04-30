/**
 * @(#) Pet.java
 */

package com.vgtu.evet.entities.pets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "pets")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotNull
	private String name;
	
	@Column
	private String color;

	@Column
	private Date birthday;

	@Enumerated(EnumType.STRING)
	@Column
	@NotNull
	private GenderType gender;

	@Column
	private boolean sterilized;

	@NotNull
	@Column
	@Enumerated(EnumType.STRING)
	private BreedType breed;

	@Column
	private boolean hidden;
}

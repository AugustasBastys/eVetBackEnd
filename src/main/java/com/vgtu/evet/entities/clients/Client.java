/**
 * @(#) Client.java
 */

package com.vgtu.evet.entities.clients;

import com.vgtu.evet.entities.pets.PetOwner;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String name;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "owner_id", referencedColumnName = "id")
//	private PetOwner owner;

}

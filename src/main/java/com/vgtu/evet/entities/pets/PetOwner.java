/**
 * @(#) Owner.java
 */

package com.vgtu.evet.entities.pets;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pet_owners")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetOwner
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

    @Column
    @NotNull
    private String name;

}
